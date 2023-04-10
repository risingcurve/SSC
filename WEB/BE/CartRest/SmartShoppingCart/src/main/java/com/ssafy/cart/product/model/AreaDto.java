package com.ssafy.cart.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Schema(name = "AreaDto : 구역 정보", description = "구역의 상세 정보를 나타낸다.")
public class AreaDto {
	@Schema(name = "구역 일련번호")
	private int area_seq;
	@Schema(name = "구역 이름")
	private String area_name;
	@Schema(name = "구역 X 좌표")
	private int area_x;
	@Schema(name = "구역 Y 좌표")
	private int area_y;
}
