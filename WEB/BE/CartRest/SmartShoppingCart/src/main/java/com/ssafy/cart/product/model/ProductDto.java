package com.ssafy.cart.product.model;

import java.util.List;

import com.ssafy.cart.image.model.ImageDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "ProductDto : 상품 정보", description = "상품의 상세 정보를 나타낸다.")
public class ProductDto {
	@Schema(name = "상품 일련번호")
	private int product_seq;
	@Schema(name = "상품 이름")
	private String product_name;
	@Schema(name = "회사 일련번호")
	private int company_seq;
	@Schema(name = "구역 일련번호")
	private int area_seq;
	@Schema(name = "단위")
	private String weight;
	@Schema(name = "상품 상세정보")
	private String product_info;
	@Schema(name = "할인 전 가격")
	private int price;
	@Schema(name = "할인 후 가격")
	private int discount_price;
	@Schema(name = "상품 할인율")
	private float discount_rate;
	@Schema(name = "재고 수량")
	private int stock;
	@Schema(name = "상품 삭제 여부")
	private boolean is_deleted;
	@Schema(name = "이미지 파일")
	private List<ImageDto> imageInfos;
}
