package com.ssafy.cart.cartlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.cartlist.model.CartDetailDto;
import com.ssafy.cart.cartlist.model.service.CartDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "장바구니 상세 내역 관련 API", description = "CartDetailController")
@Slf4j
@RestController
@RequestMapping("/cartdetail")
public class CartDetailController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private CartDetailService detailService;
	
	@Operation(summary = "장바구니 내역 한개 상세 조회", description = "장바구니 상세 일련번호(cart_detail_seq)로 모든 정보 조회")
	@GetMapping("/{cart_detail_seq}")
	public ResponseEntity<?> searchDetail(@PathVariable int cart_detail_seq) throws Exception {
		log.info("cart detail searchDetail - 호출");
		CartDetailDto detail = detailService.searchDetail(cart_detail_seq);
		if(detail != null) {
			return new ResponseEntity<CartDetailDto>(detail, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 목록 조회", description = "장바구니 일련번호로 장바구니 목록 조회")
	@GetMapping("/list/{cart_seq}")
	public ResponseEntity<?> searchDetailList(@PathVariable int cart_seq) throws Exception {
		log.info("cart detail searchDetailList - 호출");
		List<CartDetailDto> lists = detailService.searchDetailList(cart_seq);
		if(lists != null) {
			return new ResponseEntity<List<CartDetailDto>>(lists, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 상세 등록", description = "장바구니 상세 등록")
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody CartDetailDto cartDetailDto) throws Exception {
		log.info("cart detail insert - 호출");
		if(detailService.insert(cartDetailDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 상세 수정", description = "장바구니 상세 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CartDetailDto cartDetailDto) throws Exception {
		log.info("cart detail update - 호출");
		if(detailService.update(cartDetailDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 상세 삭제", description = "장바구니 상세 일련번호(cart_detail_seq)로 장바구니 상세 삭제")
	@DeleteMapping("/{cart_detail_seq}")
	public ResponseEntity<?> delete(@PathVariable int cart_detail_seq) throws Exception {
		log.info("cart detail delete - 호출");
		if(detailService.delete(cart_detail_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
