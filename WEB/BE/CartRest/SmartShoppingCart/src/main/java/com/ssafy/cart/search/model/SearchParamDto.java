package com.ssafy.cart.search.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "SearchParamDto : 검색 정보", description = "검색을 위한 상세 정보를 나타낸다.")
public class SearchParamDto {
	@Schema(name = "key")
	private String key;
	@Schema(name = "검색할 단어")
	private String word;
}
