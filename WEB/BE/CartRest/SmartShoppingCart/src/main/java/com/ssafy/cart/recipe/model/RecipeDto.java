package com.ssafy.cart.recipe.model;

import java.util.List;

import com.ssafy.cart.image.model.ImageDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(name = "RecipeDto : 레시피 정보", description = "레시피의 상세 정보를 나타낸다.")
@Getter
@Setter
public class RecipeDto {
	@Schema(name = "레시피 일련번호")
	private int recipe_seq;
	@Schema(name = "테마 일련번호")
	private int theme_seq;
	@Schema(name = "사용자 일련번호")
	private int user_seq;
	@Schema(name = "관리자 작성 여부")
	private boolean admin_chk;
	@Schema(name = "레시피 이름")
	private String recipe_name;
	@Schema(name = "레시피 상세 설명")
	private String detail;
	@Schema(name = "레시피 좋아요 수")
	private int recipe_like_cnt;
	@Schema(name = "삭제 여부")
	private boolean is_deleted;
	@Schema(name = "작성 날짜")
	private String created_date;
	@Schema(name = "수정 날짜")
	private String updated_date;
	@Schema(name = "이미지 파일")
	private List<ImageDto> imageInfos;
	@Schema(name = "레시피에 필요한 재료(상품) 목록")
	private List<RecipeDetailDto> products;
}
