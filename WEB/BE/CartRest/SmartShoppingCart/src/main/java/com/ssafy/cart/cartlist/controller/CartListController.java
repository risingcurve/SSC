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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.cartlist.model.CartDetailDto;
import com.ssafy.cart.cartlist.model.CartListDto;
import com.ssafy.cart.cartlist.model.service.CartDetailService;
import com.ssafy.cart.cartlist.model.service.CartListService;
import com.ssafy.cart.user.model.UserDto;
import com.ssafy.cart.user.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "장바구니 관련 API", description = "CartListController")
@Slf4j
@RestController
@RequestMapping("/cartlist")
public class CartListController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private CartListService cartService;
	
	@Autowired
	private CartDetailService detailService;
	
	@Autowired
	private UserService userService;
	
	@Operation(summary = "장바구니 상세 조회", description = "장바구니 일련번호로 장바구니 상세 정보 조회")
	@GetMapping("/detail/{cart_seq}")
	public ResponseEntity<?> searchCart(@PathVariable int cart_seq) throws Exception {
		log.info("cart list searchCart - 호출");
		CartListDto cart = cartService.searchCart(cart_seq);
		if(cart != null) {
			List<CartDetailDto> products = detailService.searchDetailList(cart_seq);
			cart.setProducts(products);
			return new ResponseEntity<CartListDto>(cart, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 목록 조회", description = "회원 일련번호로 장바구니 목록 정보 조회")
	@GetMapping("/{user_id}")
	public ResponseEntity<?> searchList(@PathVariable String user_id) throws Exception {
		log.info("cart list searchList - 호출");
		UserDto user = userService.userInfo(user_id);
		List<CartListDto> lists = cartService.searchList(user.getUser_seq());
		for(CartListDto list : lists) {
			list.setProducts(detailService.searchDetailList(list.getCart_seq()));
		}
		if(lists != null) {
			return new ResponseEntity<List<CartListDto>>(lists, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 등록", description = "장바구니 등록")
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody CartListDto cartListDto) throws Exception {
		log.info("cart list insert - 호출");
		log.info("cartListDto cart name : {}", cartListDto.getCart_name());
		if(cartService.insert(cartListDto)) {
			List<CartListDto> lists = cartService.searchList(cartListDto.getUser_seq());
			for(CartDetailDto product : cartListDto.getProducts()) {
				product.setCart_seq(lists.get(lists.size() - 1).getCart_seq());
				detailService.insert(product);
			}
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 수정", description = "장바구니 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CartListDto cartListDto) throws Exception {
		log.info("cart list update - 호출");
		if(cartService.update(cartListDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "장바구니 삭제", description = "장바구니 삭제")
	@DeleteMapping("/{cart_seq}")
	public ResponseEntity<?> delete(@PathVariable int cart_seq) throws Exception {
		log.info("cart list delete - 호출");
		if(cartService.delete(cart_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
