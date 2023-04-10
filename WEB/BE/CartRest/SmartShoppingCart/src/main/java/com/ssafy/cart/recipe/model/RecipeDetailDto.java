package com.ssafy.cart.recipe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "RecipeDetailDto : 레시피 상세 정보", description = "레시피에 필요한 상품 정보를 나타낸다.")
public class RecipeDetailDto {
	@Schema(name = "레시피 상세 일련번호")
	private int recipe_detail_seq;
	@Schema(name = "레시피 일련번호")
	private int recipe_seq;
	@Schema(name = "상품 일련번호")
	private int product_seq;
	@Schema(name = "필요한 상품 수량")
	private int cnt;
	
	public RecipeDetailDto(int product_seq, int cnt) {
		this.product_seq = product_seq;
		this.cnt = cnt;
	}
}
