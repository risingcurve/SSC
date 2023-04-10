package com.ssafy.cart.recipe.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "RecipeCommentDto : 레시피 댓글 정보", description = "레시피 댓글 상세 정보를 나타낸다.")
public class RecipeCommentDto {
	@Schema(name = "레시피 댓글 일련번호")
	private int recipe_comment_seq;
	@Schema(name = "레시피 일련번호")
	private int recipe_seq;
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "레시피 내용")
	private String recipe_content;
	@Schema(name = "레시피 댓글 작성 날짜")
	private String created_date;
	@Schema(name = "레시피 댓글 수정 날짜")
	private String updated_date;
	@Schema(name = "레시피 댓글 삭제 여부")
	private boolean is_deleted;
}
