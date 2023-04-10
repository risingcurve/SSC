package com.ssafy.cart.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.recipe.model.ThemeDto;
import com.ssafy.cart.recipe.model.service.ThemeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "테마 관련 API", description = "ThemeController")
@Slf4j
@RestController
@RequestMapping("/theme")
public class ThemeController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ThemeService themeService;
	
	@Operation(summary = "테마 한개 조회", description = "테마 이름으로 테마 한개 조회")
	@GetMapping("/name/{theme_name}")
	public ResponseEntity<?> searchByName(@PathVariable("theme_name") String theme_name) throws Exception {
		log.info("theme name searchByName - 호출");
		ThemeDto theme = themeService.searchByName(theme_name);
		if(theme != null) {
			return new ResponseEntity<ThemeDto>(theme, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "테마 한개 조회", description = "테마 일련번호로 테마 한개 조회")
	@GetMapping("/seq/{theme_seq}")
	public ResponseEntity<?> searchBySeq(@PathVariable("theme_seq") int theme_seq) throws Exception {
		log.info("theme searchBySeq - 호출");
		ThemeDto theme = themeService.searchBySeq(theme_seq);
		if(theme != null) {
			return new ResponseEntity<ThemeDto>(theme, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "테마 조회", description = "모든 테마 조회")
	@GetMapping
	public ResponseEntity<?> searchList() throws Exception {
		List<ThemeDto> themes = themeService.searchList();
		if(themes != null) {
			return new ResponseEntity<List<ThemeDto>>(themes, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "테마 등록", description = "테마 등록")
	@PostMapping
	public ResponseEntity<?> insertTheme(String theme_name) throws Exception {
		if(themeService.insert(theme_name)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "테마 수정", description = "테마 수정")
	@PutMapping
	public ResponseEntity<?> updateTheme(@RequestBody ThemeDto themeDto) throws Exception {
		if(themeService.update(themeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "테마 삭제", description = "테마 삭제")
	@DeleteMapping("/{theme_seq}")
	public ResponseEntity<?> deleteTheme(@PathVariable("theme_seq") int theme_seq) throws Exception {
		if(themeService.delete(theme_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
