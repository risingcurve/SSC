package com.ssafy.cart.user.model;

import java.util.List;

import com.ssafy.cart.image.model.ImageDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "UserDto : 회원 정보", description = "회원의 상세 정보를 나타낸다.")
public class UserDto {
	@Schema(name = "회원 일련번호")
	private int user_seq;
	@Schema(name = "회원 아이디")
	private String user_id;
	@Schema(name = "회원 비밀번호")
	private String user_pwd;
	@Schema(name = "회원 이름")
	private String user_name;
	@Schema(name = "회원 이메일 아이디")
	private String email_id;
	@Schema(name = "회원 이메일 도메인")
	private String email_domain;
	@Schema(name = "회원 전화번호")
	private String phone;
	@Schema(name = "회원 생년월일")
	private String birth;
	@Schema(name = "회원 성별")
	private char gender;
	@Schema(name = "회원 가입 날짜")
	private String created_date;
	@Schema(name = "관리자 여부")
	private boolean is_admin;
	@Schema(name = "회원 탈퇴 여부")
	private boolean is_valid;
	@Schema(name = "이미지 파일")
	private List<ImageDto> imageInfos;
	@Schema(name = "refresh-token")
	private String token;
}
