package com.ssafy.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssafy.cart.model.repo")
//@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(
//		title = "Smart Shopping Cart API", 
//		version = "v1.0.0", 
//		description = "SSC(Smart Shopping Cart) 관련 API"
//	)
//	, servers = {
//			@Server(url = "/api", description = "Default Server URL")
//	}
//)
public class SmartShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartShoppingCartApplication.class, args);
	}

}
