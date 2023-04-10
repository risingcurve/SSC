package com.ssafy.cart.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@Schema(name = "ProductCommentDto : 상품 후기 정보", description = "상품 후기의 상세 정보를 나타낸다.")
public class ProductCommentDto {
	@Schema(name = "상품 후기 일련번호")
	private int product_comment_seq;
	@Schema(name = "상품 일련번호")
	private int product_seq;
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "상품 후기 제목")
	private String title;
	@Schema(name = "상품 후기 상세 내용")
	private String detail;
	@Schema(name = "상품 후기 별점")
	private float star_point;
	@Schema(name = "상품 후기 작성 날짜")
	private String created_date;
	@Schema(name = "상품 후기 수정 날짜")
	private String updated_date;
}
