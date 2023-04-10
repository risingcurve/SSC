package com.ssafy.cart.image.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "ImageDto : 이미지 정보", description = "이미지의 상세 정보를 나타낸다.")
public class ImageDto {
	@Schema(name = "이미지 일련번호")
	private int image_seq;
	@Schema(name = "통합 일련번호")
	private int integ_seq;
	@Schema(name = "이미지 원본 이름")
	private String origin_name;
	@Schema(name = "이미지 저장 폴더 경로")
	private String save_folder;
	@Schema(name = "저장될 이미지 이름")
	private String save_name;
	@Schema(name = "이미지 사이즈")
	private int size;
	@Schema(name = "이미지 생성 날짜")
	private String created_date;
	@Schema(name = "이미지 삭제 여부")
	private boolean is_deleted;
	@Schema(name = "대표 이미지 여부")
	private boolean primary_image;
}
