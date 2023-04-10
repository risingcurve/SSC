package com.ssafy.cart.user.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.cart.image.model.ImageDto;
import com.ssafy.cart.image.model.service.ImageService;
import com.ssafy.cart.user.model.UserDto;
import com.ssafy.cart.user.model.service.JwtService;
import com.ssafy.cart.user.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "사용자 관련 API", description = "UserController")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private JwtService jwtService;
	
	@Operation(summary = "회원 로그인", description = "Access-token과 로그인 결과 메세지를 반환한다.")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto) {
		log.info("user login - 호출");
		log.info("userDto : {}", userDto.toString());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(userDto);
			if(loginUser != null) {
				log.info("accessToken");
				log.info(loginUser.toString());
				String accessToken = jwtService.createAccessToken("user_id", loginUser.getUser_id());
				log.info("refreshToken");
				String refreshToken = jwtService.createRefreshToken("user_id", loginUser.getUser_id());
				userService.saveRefreshToken(userDto.getUser_id(), refreshToken);
				log.debug("로그인 accessToken 정보 : {}", accessToken);
				log.debug("로그인 refreshToken 정보 : {}", refreshToken);
				
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch(Exception e) {
			log.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@Operation(summary = "회원 인증", description = "회원 정보를 담은 Token 반환")
	@PostMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(String user_id, HttpServletRequest request) {
		log.info("회원인증 getInfo - 호출");
		log.info("user_id : {}", user_id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if(jwtService.checkToken(request.getHeader("access-token"))) {
			log.info("사용 가능한 토큰");
			try {
				UserDto user = userService.userInfo(user_id);
				resultMap.put("userInfo", user);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch(Exception e) {
				log.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			log.error("사용 불가능한 토큰!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@Operation(summary = "회원 로그아웃", description = "회원 정보를 담은 Token 제거")
	@PostMapping("/logout")
	public ResponseEntity<?> removeToken(@RequestBody UserDto userDto) {
		log.info("user logout - 호출");
		log.info("userDto : {}", userDto.toString());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userDto.getUser_id());
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch(Exception e) {
			log.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@Operation(summary = "Access Token 재발급", description = "유효한 refresh-token으로 요청시 만료된 access-token 재발급")
	@GetMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request) throws Exception {
		log.info("user refreshToken - 호출");
		log.info("userDto : {}", userDto.toString());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		log.debug("token : {}, userDto : {}", token, userDto);
		if(jwtService.checkToken(token)) {
			if(token.equals(userService.getRefreshToken(userDto.getUser_id()))) {
				String accessToken = jwtService.createAccessToken("user_id", userDto.getUser_id());
				log.debug("token : {}", accessToken);
				log.debug("정상적으로 액세스 토큰 재발급!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			log.debug("refresh-token도 사용 불가능!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@Operation(summary = "회원 정보 조회", description = "회원 일련번호(user_seq)로 회원의 모든 정보 조회")
	@GetMapping("/all/{user_seq}")
	public ResponseEntity<?> userInfoAll(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("user userInfoAll - 호출");
		log.debug("userseq : {}", user_seq);
		UserDto user = userService.userInfoAll(user_seq);
		if(user != null) {
			System.out.println(user.getUser_name());
			List<ImageDto> images = imageService.searchList(userService.integInfo(user.getUser_seq()));
			user.setImageInfos(images);
			return new ResponseEntity<UserDto>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원 정보 조회", description = "회원 아이디(user_id)로 아이디, 비밀번호, 이름, 이메일, 핸드폰번호, 생년월일, 성별, 가입날짜 조회")
	@GetMapping("/{user_id}")
	public ResponseEntity<?> userInfo(@PathVariable("user_id") String user_id) throws Exception {
		log.info("user userInfo - 호출");
		log.debug("user id : {}", user_id);
		UserDto user = userService.userInfo(user_id);
		if(user != null) {
			List<ImageDto> images = imageService.searchList(userService.integInfo(user.getUser_seq()));
			user.setImageInfos(images);
			return new ResponseEntity<UserDto>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원 등록", description = "회원가입")
//	@PostMapping(value = "/regist", consumes = "multipart/data-form")
	@PostMapping
	public ResponseEntity<?> regist(@Value("${file.path.upload-user}") String filePath, @RequestParam(name = "upfile", required = false) MultipartFile[] files, UserDto userDto) throws Exception {
		log.info("user regist - 호출");
		log.info("userDto : {}", userDto.toString());
//		log.debug(userDto.getUser_id());
		if(userService.regist(userDto)) {
			log.info("userInfo - 호출");
			UserDto user = userService.userInfo(userDto.getUser_id());
			log.info("insertIntegration - 호출");
			userService.insertIntegraion(user.getUser_seq());
			log.info("integInfo - 호출");
			int integ = userService.integInfo(user.getUser_seq());

			log.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
			if(!files[0].isEmpty()) {
				log.info("image upload");
//				String today = new SimpleDateFormat("yyMMdd").format(new Date());
				String saveFolder = filePath;
				log.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if(!folder.exists()) {
					log.info("지정한 폴더를 찾을 수 없음!");
					folder.mkdir();
				}
				
				List<ImageDto> imageInfos = new ArrayList<ImageDto>();
				for(MultipartFile mfile : files) {
					ImageDto imageDto = new ImageDto();
					String originalFileName = mfile.getOriginalFilename();
					if(!originalFileName.isEmpty()) {
						log.info("originalFileName : {}", originalFileName);
						String saveFileName = userDto.getUser_id() + originalFileName.substring(originalFileName.lastIndexOf('.'));
						imageDto.setInteg_seq(integ);
						imageDto.setSave_name(saveFileName);
						imageDto.setOrigin_name(originalFileName);
						imageDto.setSave_folder(saveFolder);
						imageService.insert(imageDto);
						mfile.transferTo(new File(folder, saveFileName));
					}
					imageInfos.add(imageDto);
				}
				userDto.setImageInfos(imageInfos);
			}
		
			return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원 정보 수정", description = "회원 정보 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody UserDto userDto) throws Exception {
		log.info("user update - 호출");
		log.info("userDto : {}", userDto.toString());
		if(userService.update(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원 탈퇴", description = "회원 탈퇴 처리")
	@PutMapping("/{user_seq}")
	public ResponseEntity<?> leave(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("user leave - 호출");
		log.info("user_seq : {}", user_seq);
		UserDto user = userService.userInfoAll(user_seq);
		if(user != null) {
			userService.leave(user_seq);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원 정보 삭제", description = "회원 정보 삭제")
	@DeleteMapping("/{user_seq}")
	public ResponseEntity<?> delete(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("user delete - 호출");
		log.info("user_seq : {}", user_seq);
		if(userService.delete(user_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
