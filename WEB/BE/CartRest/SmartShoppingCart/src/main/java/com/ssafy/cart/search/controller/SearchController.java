package com.ssafy.cart.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.product.model.ProductDto;
import com.ssafy.cart.product.model.service.ProductService;
import com.ssafy.cart.recipe.model.RecipeDto;
import com.ssafy.cart.recipe.model.service.RecipeService;
import com.ssafy.cart.search.model.SearchParamDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "검색 관련 API", description = "SearchController")
@Slf4j
@RestController
@RequestMapping("/search")
public class SearchController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Operation(summary = "검색바 검색", description = "word(현재 상품 이름)가 사용된 레시피 목록과 word(현재 상품 이름)이 포함된 상품 목록 반환")
	@GetMapping
	public ResponseEntity<?> search(SearchParamDto searchParamDto) throws Exception {
		log.info("search search - 호출");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		if(searchParamDto != null) {
		
			ProductDto product = productService.searchByName(searchParamDto.getWord());
			if(product != null) {
				List<RecipeDto> recipeList = recipeService.searchListByProductSeq(product.getProduct_seq());
				resultMap.put("recipes", recipeList);
			} else {
				resultMap.put("recipes", null);
			}
			
			searchParamDto.setKey("name");
			List<ProductDto> productList = productService.productList(searchParamDto);
			resultMap.put("products", productList);
			
			resultMap.put("messsage", SUCCESS);
			status = HttpStatus.OK;
		} else {
			resultMap.put("message", FAIL);
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
