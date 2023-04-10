package com.ssafy.cart.purchase.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "PurchaseDto : 구매내역 정보", description = "구매내역의 상세 정보를 나타낸다.")
public class PurchaseDto {
	@Schema(name = "구매내역 일련번호")
	private int purchase_seq;
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "구매 날짜")
	private String purchase_date;
	@Schema(name = "총 금액")
	private int total_price;
	@Schema(name = "구매한 상품 목록")
	private List<PurchaseDetailDto> products;
}
