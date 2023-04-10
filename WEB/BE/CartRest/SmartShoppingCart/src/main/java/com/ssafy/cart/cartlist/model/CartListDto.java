package com.ssafy.cart.cartlist.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "CartListDto : 장바구니 정보", description = "장바구니의 상세 정보를 나타낸다.")
public class CartListDto {
	@Schema(name = "장바구니 일련번호")
	private int cart_seq;
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "장바구니 이름")
	private String cart_name;
	@Schema(name = "장바구니 생성 날짜")
	private String created_date;
	@Schema(name = "장바구니 가격 총 합계")
	private int total_price;
	@Schema(name = "장바구니 상품 목록")
	private List<CartDetailDto> products;
}
