package com.ssafy.cart.cartlist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "CartDetailDto : 장바구니 상세 정보", description = "장바구니 목록 중 상품 하나의 상세 정보를 나타낸다.")
public class CartDetailDto {
	@Schema(name = "장바구니 상세 일련번호")
	private int cart_detail_seq;
	@Schema(name = "장바구니 일련번호")
	private int cart_seq;
	@Schema(name = "상품 일련번호")
	private int product_seq;
	@Schema(name = "상품 개수")
	private int cnt;
	@Schema(name = "상품 가격")
	private int price;
	@Schema(name = "상품의 할인된 가격")
	private int discount_price;
}
