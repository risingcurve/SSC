package com.ssafy.cart.recipe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "RecipeLikeDto : 레시피 좋아요 정보", description = "레시피 좋아요의 상세 정보를 나타낸다.")
public class RecipeLikeDto {
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "레시피 일련번호")
	private int recipe_seq;
}
