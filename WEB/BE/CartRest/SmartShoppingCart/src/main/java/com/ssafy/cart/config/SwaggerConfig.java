package com.ssafy.cart.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
				.title("Smart Shopping Cart API")
				.version("v1")
				.description("SSC(Smart Shopping Cart) 관련 API\n"
						+ "- 회원 API\n"
						+ "- 레시피 API\n"
						+ "- 상품 API\n"
						+ "- 장바구니 API\n"
						+ "- 구매내역 API\n"
						+ "- 이미지 API\n"
						+ "- 통합 API\n"
						+ "- 검색 API\n");
		return new OpenAPI()
				.addServersItem(new Server().url("/api"))
				.components(new Components())
				.info(info);
	}
	
	@Bean
	public GroupedOpenApi Api() {
		return GroupedOpenApi.builder()
				.group("Api 전체")
				.packagesToScan("com.ssafy.cart")
				.build();
	}
	
	@Bean
	public GroupedOpenApi UserApi() {
		return GroupedOpenApi.builder()
				.group("회원 API")
				.packagesToScan("com.ssafy.cart.user.controller")
				.build();
	}
	
	@Bean
	public GroupedOpenApi ProductApi() {
		return GroupedOpenApi.builder()
				.group("상품 API")
				.packagesToScan("com.ssafy.cart.product.controller")
				.build();
	}
	
	@Bean
	public GroupedOpenApi CartlistApi() {
		return GroupedOpenApi.builder()
				.group("장바구니 API")
				.packagesToScan("com.ssafy.cart.cartlist.controller")
				.build();
	}
	
	@Bean
	public GroupedOpenApi ImageApi() {
		return GroupedOpenApi.builder()
				.group("이미지 API")
				.packagesToScan("com.ssafy.cart.image.controller")
				.build();
	}
	
	@Bean
	public GroupedOpenApi IntegrationApi() {
		return GroupedOpenApi.builder()
				.group("통합 API")
				.packagesToScan("com.ssafy.cart.integration")
				.build();
	}
	
	@Bean
	public GroupedOpenApi PurchaseApi() {
		return GroupedOpenApi.builder()
				.group("구매 내역 API")
				.packagesToScan("com.ssafy.cart.purchase.controller")
				.build();
	}
	
	@Bean
	public GroupedOpenApi RecipeApi() {
		return GroupedOpenApi.builder()
				.group("레시피 API")
				.packagesToScan("com.ssafy.cart.recipe.controller")
				.build();
	}
	
	@Bean
	public GroupedOpenApi SearchApi() {
		return GroupedOpenApi.builder()
				.group("검색 API")
				.packagesToScan("com.ssafy.cart.search.controller")
				.build();
	}
}
