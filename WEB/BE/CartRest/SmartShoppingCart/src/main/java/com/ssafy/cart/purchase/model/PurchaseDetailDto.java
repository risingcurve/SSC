package com.ssafy.cart.purchase.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "PurchaseDetailDto : 구매내역 상세 정보", description = "구매내역 상세 정보를 나타낸다.")
public class PurchaseDetailDto {
	@Schema(name = "구매내역 상세 일련번호")
	private int purchase_detail_seq;
	@Schema(name = "구매내역 일련번호")
	private int purchase_seq;
	@Schema(name = "상품 일련번호")
	private int product_seq;
	@Schema(name = "수량")
	private int cnt;
	@Schema(name = "가격")
	private int price;
	@Schema(name = "할인된 가격")
	private int discount_price;
}
