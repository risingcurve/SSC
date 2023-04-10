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

import com.ssafy.cart.recipe.model.RecipeCommentDto;
import com.ssafy.cart.recipe.model.service.RecipeCommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "레시피 댓글 관련 API", description = "RecipeCommentController")
@Slf4j
@RestController
@RequestMapping("/recipecomment")
public class RecipeCommentController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private RecipeCommentService commentService;
	
	@Operation(summary = "레시피 댓글 상세 조회", description = "레시피 일련번호로 레시피 댓글의 상세 정보를 조회한다.")
	@GetMapping("/recipecommentseq/{recipe_comment_seq}")
	public ResponseEntity<?> searchByCommentSeq(@PathVariable int recipe_comment_seq) throws Exception {
		log.info("recipecomment searchByCommentSeq - 호출");
		RecipeCommentDto comment = commentService.searchByCommentSeq(recipe_comment_seq);
		if(comment != null) {
			return new ResponseEntity<RecipeCommentDto>(comment, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 댓글 목록 조회", description = "레시피 일련번호로 레시피 댓글 목록을 조회한다.")
	@GetMapping("/recipeseq/{recipe_seq}")
	public ResponseEntity<?> searchByRecipeSeq(@PathVariable int recipe_seq) throws Exception {
		log.info("recipecomment searchByRecipeSeq - 호출");
		List<RecipeCommentDto> comments = commentService.searchByRecipeSeq(recipe_seq);
		if(comments != null) {
			return new ResponseEntity<List<RecipeCommentDto>>(comments, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 댓글 목록 조회", description = "회원 일련번호로 레시피 댓글 목록을 조회한다.")
	@GetMapping("/userseq/{user_seq}")
	public ResponseEntity<?> searchByUserSeq(@PathVariable int user_seq) throws Exception {
		log.info("recipecomment searchByUserSeq - 호출");
		List<RecipeCommentDto> comments = commentService.searchByUserSeq(user_seq);
		if(comments != null) {
			return new ResponseEntity<List<RecipeCommentDto>>(comments, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 댓글 등록", description = "레시피 댓글 등록")
	@PostMapping()
	public ResponseEntity<?> insertRecipeComment(@RequestBody RecipeCommentDto recipeCommentDto) throws Exception {
		log.info("recipecomment insertRecipeComment - 호출");
		if(commentService.insertRecipeComment(recipeCommentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 댓글 수정", description = "레시피 댓글 수정")
	@PutMapping()
	public ResponseEntity<?> updateRecipeComment(@RequestBody RecipeCommentDto recipeCommentDto) throws Exception {
		log.info("recipecomment updateRecipeComment - 호출");
		if(commentService.updateRecipeComment(recipeCommentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 댓글 삭제 처리", description = "레시피 댓글 삭제 처리")
	@PutMapping("/{recipe_comment_seq}")
	public ResponseEntity<?> isDeleted(@PathVariable int recipe_comment_seq) throws Exception {
		log.info("recipecomment isDeleted - 호출");
		if(commentService.isDeleted(recipe_comment_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "레시피 댓글 삭제", description = "레시피 댓글 삭제")
	@DeleteMapping("/{recipe_comment_seq}")
	public ResponseEntity<?> deleteRecipeComment(@PathVariable int recipe_comment_seq) throws Exception {
		log.info("recipecomment deleteRecipeComment - 호출");
		if(commentService.deleteRecipeComment(recipe_comment_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
