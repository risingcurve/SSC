package com.ssafy.cart.purchase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.purchase.model.PurchaseDetailDto;
import com.ssafy.cart.purchase.model.PurchaseDto;
import com.ssafy.cart.purchase.model.service.PurchaseDetailService;
import com.ssafy.cart.purchase.model.service.PurchaseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "구매내역 관련 API", description = "PurchaseController")
@Slf4j
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private PurchaseDetailService detailService;
	
	@Operation(summary = "구매내역 조회", description = "회원 일련번호로 구매내역 조회")
	@GetMapping("/{user_seq}")
	public ResponseEntity<?> searchList(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("purchase searchList - 호출");
		List<PurchaseDto> purchaseList = purchaseService.searchList(user_seq);
		if(purchaseList != null) {
			for(PurchaseDto purchase : purchaseList) {
				List<PurchaseDetailDto> products = detailService.searchByPurchaseSeq(purchase.getPurchase_seq());
				purchase.setProducts(products);
			}
			return new ResponseEntity<List<PurchaseDto>>(purchaseList, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "구매내역 등록", description = "구매내역 정보 등록")
	@PostMapping
	public ResponseEntity<?> regist(@RequestBody PurchaseDto purchaseDto) throws Exception {
		log.info("purchase regist - 호출");
		if(purchaseService.regist(purchaseDto)) {
			List<PurchaseDto> userlist = purchaseService.searchList(purchaseDto.getUser_seq());
			PurchaseDto purchase = userlist.get(userlist.size() - 1);
			
			List<PurchaseDetailDto> products = purchaseDto.getProducts();
			for(PurchaseDetailDto product : products) {
				product.setPurchase_seq(purchase.getPurchase_seq());
				detailService.insert(product);
			}
			
			purchaseService.updateTotalPrice(purchase.getPurchase_seq());
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
