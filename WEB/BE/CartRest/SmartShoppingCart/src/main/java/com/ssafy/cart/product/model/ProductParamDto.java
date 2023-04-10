package com.ssafy.cart.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "ProductParamDto : 상품 검색 정보", description = "상품 검색을 위한 상세 정보를 나타낸다.")
public class ProductParamDto {
	@Schema(name = "페이지 번호")
	private int pg;
	@Schema(name = "한 페이지에 보여줄 개수")
	private int spp;
	@Schema(name = "시작 번호")
	private int start;
	@Schema(name = "회사명 또는 카테고리")
	private String key;
	@Schema(name = "검색할 단어")
	private String word;
}
