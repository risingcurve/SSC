package com.ssafy.cart.recipe.model.service;

import java.util.List;

import com.ssafy.cart.recipe.model.RecipeDetailDto;

public interface RecipeDetailService {
	public List<RecipeDetailDto> searchByRecipeSeq(int recipe_seq) throws Exception;
	public List<RecipeDetailDto> searchByProductSeq(int product_seq) throws Exception;
	public boolean insert(RecipeDetailDto recipeDetailDto) throws Exception;
	public boolean update(RecipeDetailDto recipeDetailDto) throws Exception;
	public boolean delete(int recipe_detail_seq) throws Exception;
}
