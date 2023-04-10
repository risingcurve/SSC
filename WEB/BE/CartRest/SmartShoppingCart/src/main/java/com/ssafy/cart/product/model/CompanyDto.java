package com.ssafy.cart.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "CompanyDto : 회사 정보", description = "회사의 상세 정보를 나타낸다.")
public class CompanyDto {
	@Schema(name = "회사 일련번호")
	private int company_seq;
	@Schema(name = "회사 이름")
	private String company_name;
}
