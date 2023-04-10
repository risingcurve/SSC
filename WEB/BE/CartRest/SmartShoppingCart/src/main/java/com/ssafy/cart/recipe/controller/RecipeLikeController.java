package com.ssafy.cart.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.recipe.model.RecipeLikeDto;
import com.ssafy.cart.recipe.model.service.RecipeLikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "레시피 좋아요 관련 API", description = "RecipeLikeController")
@Slf4j
@RestController
@RequestMapping("/like")
public class RecipeLikeController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private RecipeLikeService likeService;
	
	@Operation(summary = "레시피 좋아요", description = "recipe_like 테이블에 값 입력 후, recipe 테이블의 recipe_like_cnt 변경")
	@PostMapping
	public ResponseEntity<?> like(@RequestBody RecipeLikeDto recipeLikeDto) throws Exception {
		log.info("recipe like - 호출");
		if(likeService.like(recipeLikeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 좋아요 취소", description = "recipe_like 테이블에 값 삭제 후, recipe 테이블의 recipe_like_cnt 변경")
	@DeleteMapping
	public ResponseEntity<?> cancel(@RequestBody RecipeLikeDto recipeLikeDto) throws Exception {
		log.info("recipe cancel - 호출");
		if(likeService.cancel(recipeLikeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
