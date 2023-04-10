package com.ssafy.cart.recipe.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.cart.image.model.ImageDto;
import com.ssafy.cart.image.model.service.ImageService;
import com.ssafy.cart.recipe.model.RecipeDetailDto;
import com.ssafy.cart.recipe.model.RecipeDto;
import com.ssafy.cart.recipe.model.service.RecipeDetailService;
import com.ssafy.cart.recipe.model.service.RecipeService;
import com.ssafy.cart.user.model.UserDto;
import com.ssafy.cart.user.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "레시피 관련 API", description = "RecipeController")
@Slf4j
@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeDetailService detailService;
	
	@Operation(summary = "레시피 목록 조회", description = "테마 일련번호로 레시피 목록 조회")
	@GetMapping("/theme/{theme_seq}")
	public ResponseEntity<?> searchListByTheme(@PathVariable("theme_seq") int theme_seq) throws Exception {
		log.info("recipe searchListByTheme - 호출");
		List<RecipeDto> recipeList = recipeService.searchListByTheme(theme_seq);
		if(recipeList != null) {
			for(RecipeDto recipe : recipeList) {
				List<ImageDto> images = imageService.searchList(recipeService.integInfo(recipe.getRecipe_seq()));
				recipe.setImageInfos(images);
				List<RecipeDetailDto> products = detailService.searchByRecipeSeq(recipe.getRecipe_seq());
				recipe.setProducts(products);
			}
			return new ResponseEntity<List<RecipeDto>>(recipeList, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 상세 조회", description = "레시피 일련번호로 상세 정보 조회")
	@GetMapping("/{recipe_seq}")
	public ResponseEntity<?> detailByRecipeSeq(@PathVariable("recipe_seq") int recipe_seq) throws Exception {
		log.info("recipe detailByRecipeSeq - 호출");
		RecipeDto recipe = recipeService.detailByRecipeSeq(recipe_seq);
		if(recipe != null) {
			List<ImageDto> images = imageService.searchList(recipeService.integInfo(recipe_seq));
			recipe.setImageInfos(images);
			List<RecipeDetailDto> products = detailService.searchByRecipeSeq(recipe_seq);
			recipe.setProducts(products);
			return new ResponseEntity<RecipeDto>(recipe, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품이 사용된 레시피 목록 조회", description = "상품 일련번호로 상품이 사용되는 레시피 목록 조회")
	@GetMapping("/product/{product_seq}")
	public ResponseEntity<?> searchByProductSeq(@PathVariable("product_seq") int product_seq) throws Exception {
		log.info("recipe product search searchByProductSeq - 호출");
		List<RecipeDetailDto> details = detailService.searchByProductSeq(product_seq);
		List<RecipeDto> recipes = new ArrayList<>();
		for(RecipeDetailDto detail : details) {
			RecipeDto recipe = recipeService.detailByRecipeSeq(detail.getRecipe_seq());
			List<ImageDto> images = imageService.searchList(recipeService.integInfo(detail.getRecipe_seq()));
			recipe.setImageInfos(images);
			List<RecipeDetailDto> products = detailService.searchByRecipeSeq(detail.getRecipe_seq());
			recipe.setProducts(products);
			recipes.add(recipe);
		}
		if(!recipes.isEmpty()) {
			return new ResponseEntity<List<RecipeDto>>(recipes, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원이 작성한 레시피 목록 조회", description = "회원 일련번호로 회원이 작성한 레시피 목록 조회")
	@GetMapping("/user/{user_seq}")
	public ResponseEntity<?> searchListByUserSeq(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("recipe user search searchListByUserSeq - 호출");
		List<RecipeDto> recipes = recipeService.searchListByUserSeq(user_seq);
		for(RecipeDto recipe : recipes) {
			List<ImageDto> images = imageService.searchList(recipeService.integInfo(recipe.getRecipe_seq()));
			recipe.setImageInfos(images);
			List<RecipeDetailDto> products = detailService.searchByRecipeSeq(recipe.getRecipe_seq());
			recipe.setProducts(products);
		}
		if(!recipes.isEmpty()) {
			return new ResponseEntity<List<RecipeDto>>(recipes, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 등록", description = "레시피 등록")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//	@PostMapping
	public ResponseEntity<?> userRegist(@Value("${file.path.upload-recipe}") String filePath, @RequestParam(name = "upfile", required = false) MultipartFile[] files, RecipeDto recipeDto,@RequestPart("details") List<RecipeDetailDto> products) throws Exception {
		log.info("recipe userRegist - 호출");
		log.info("recipe : {}", recipeDto);
		if(recipeDto != null) {
			UserDto user = userService.userInfoAll(recipeDto.getUser_seq());
			if(user.is_admin()) recipeDto.setAdmin_chk(true);
			else recipeDto.setAdmin_chk(false);
			log.info("recipe regist - 호출");
			recipeService.regist(recipeDto);
			RecipeDto recipe = recipeService.detailByRecipeName(recipeDto.getRecipe_name());
			recipeService.insertIntegration(recipe.getRecipe_seq());
			int integ = recipeService.integInfo(recipe.getRecipe_seq());
			log.info("integ : {}", integ);
			
			log.info("재료 목록 시작");
			log.info("products.isEmpty : {}", products.isEmpty());
			for(RecipeDetailDto product : products) {
				product.setRecipe_seq(recipe.getRecipe_seq());
				detailService.insert(product);
			}
			
			log.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
			if(!files[0].isEmpty()) {
				log.info("image upload");
//				String today = new SimpleDateFormat("yyMMdd").format(new Date());
				String saveFolder = filePath + File.separator + recipeDto.getRecipe_name();
				log.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if(!folder.exists()) {
					folder.mkdir();
				}
				
				List<ImageDto> imageInfos = new ArrayList<ImageDto>();
				int num = 1;
				for(MultipartFile mfile : files) {
					ImageDto imageDto = new ImageDto();
					String originalFileName = mfile.getOriginalFilename();
					if(!originalFileName.isEmpty()) {
						log.info("originalFileName : {}", originalFileName);
						String saveFileName = recipeDto.getRecipe_name()+ num + originalFileName.substring(originalFileName.lastIndexOf('.'));
						imageDto.setInteg_seq(integ);
						imageDto.setSave_name(saveFileName);
						imageDto.setOrigin_name(originalFileName);
						imageDto.setSave_folder(saveFolder);
						if(num == 1) imageDto.setPrimary_image(true);
						imageService.insert(imageDto);
						mfile.transferTo(new File(folder, saveFileName));
					}
					imageInfos.add(imageDto);
					num++;
				}
				recipeDto.setImageInfos(imageInfos);
			}
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 수정", description = "레시피 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody RecipeDto recipeDto) throws Exception {
		log.info("recipe update - 호출");
		if(recipeService.update(recipeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 삭제 처리", description = "레시피 삭제 처리")
	@PutMapping("/isDeleted")
	public ResponseEntity<?> isDeleted(@RequestBody int recipe_seq) throws Exception {
		log.info("recipe isDeleted - 호출");
		if(recipeService.isDeleted(recipe_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 삭제", description = "레시피 삭제")
	@DeleteMapping("/{recipe_seq}")
	public ResponseEntity<?> delete(@PathVariable int recipe_seq) throws Exception {
		log.info("recipe delete - 호출");
		if(recipeService.delete(recipe_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
