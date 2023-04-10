package com.ssafy.cart.integration.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "IntegrationDto : 통합 정보", description = "회원, 레시피, 상품의 통합 일련번호 정보를 나타낸다.")
public class IntegrationDto {
	@Schema(name = "통합 일련번호")
	private int integ_seq;
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "레시피 일련번호")
	private int recipe_seq;
	@Schema(name = "상품 일련번호")
	private int product_seq;
}
