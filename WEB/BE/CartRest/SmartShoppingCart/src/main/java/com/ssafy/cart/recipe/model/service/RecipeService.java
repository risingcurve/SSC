package com.ssafy.cart.recipe.model.service;

import java.util.List;

import com.ssafy.cart.recipe.model.RecipeDto;

public interface RecipeService {
	public List<RecipeDto> searchListByTheme(int theme_seq) throws Exception;
	public List<RecipeDto> searchListByProductSeq(int product_seq) throws Exception;
	public List<RecipeDto> searchListByUserSeq(int user_seq) throws Exception;
	public RecipeDto detailByRecipeName(String recipe_name) throws Exception;
	public RecipeDto detailByRecipeSeq(int recipe_seq) throws Exception;
	public boolean regist(RecipeDto recipeDto) throws Exception;
	public boolean update(RecipeDto recipeDto) throws Exception;
	public boolean updateLikeCnt(int recipe_seq) throws Exception;
	public boolean isDeleted(int recipe_seq) throws Exception;
	public boolean delete(int recipe_seq) throws Exception;
	public boolean insertIntegration(int recipe_seq) throws Exception;
	public int integInfo(int recipe_seq) throws Exception;
}
