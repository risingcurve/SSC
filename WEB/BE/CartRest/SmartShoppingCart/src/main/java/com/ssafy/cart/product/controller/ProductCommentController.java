package com.ssafy.cart.product.controller;

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

import com.ssafy.cart.product.model.ProductCommentDto;
import com.ssafy.cart.product.model.service.ProductCommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "상품 후기 관련 API", description = "ProductCommentController")
@Slf4j
@RestController
@RequestMapping("/productcomment")
public class ProductCommentController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ProductCommentService pcommentService;
	
	@Operation(summary = "상품 후기 등록", description = "상품 후기 등록")
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ProductCommentDto commentDto) throws Exception {
		log.info("Product Comment insert - 호출");
		if(pcommentService.insert(commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 후기 수정", description = "상품 후기 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ProductCommentDto commentDto) throws Exception {
		log.info("Product Comment update - 호출");
		if(pcommentService.update(commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 후기 삭제", description = "상품 후기 삭제")
	@DeleteMapping("/{product_comment_seq}")
	public ResponseEntity<?> delete(@PathVariable("product_comment_seq") int product_comment_seq) throws Exception {
		log.info("product comment delete - 호출");
		if(pcommentService.delete(product_comment_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 후기 한개 상세 조회", description = "상품 후기 한개 상세 조회")
	@GetMapping("/{product_comment_seq}")
	public ResponseEntity<?> searchComment(@PathVariable("product_comment_seq") int product_comment_seq) throws Exception {
		log.info("product comment searchComment - 호출");
		ProductCommentDto comment = pcommentService.searchComment(product_comment_seq); 
		if(comment != null) {
			return new ResponseEntity<ProductCommentDto>(comment, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 후기 목록 조회", description = "상품 후기 목록 조회")
	@GetMapping("/list/{product_seq}")
	public ResponseEntity<?> searchList(@PathVariable("product_seq") int product_seq) throws Exception {
		log.info("product comment searchList - 호출");
		List<ProductCommentDto> comments = pcommentService.searchList(product_seq);
		if(comments != null) {
			return new ResponseEntity<List<ProductCommentDto>>(comments, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회원이 작성한 상품 후기 목록 조회", description = "회원이 작성한 상품 후기 목록 조회")
	@GetMapping("/list/user/{user_seq}")
	public ResponseEntity<?> searchListByUserSeq(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("product comment searchList - 호출");
		List<ProductCommentDto> comments = pcommentService.searchListByUserSeq(user_seq);
		if(comments != null) {
			return new ResponseEntity<List<ProductCommentDto>>(comments, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
