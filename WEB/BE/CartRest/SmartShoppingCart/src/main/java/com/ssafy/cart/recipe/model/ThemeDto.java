package com.ssafy.cart.recipe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "ThemeDto : 테마 정보", description = "테마의 상세 정보를 나타낸다.")
public class ThemeDto {
	@Schema(name = "테마 일련번호")
	private int theme_seq;
	@Schema(name = "테마 이름")
	private String theme_name;
}
