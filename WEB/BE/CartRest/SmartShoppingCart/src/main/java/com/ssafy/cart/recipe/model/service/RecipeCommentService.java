package com.ssafy.cart.recipe.model.service;

import java.util.List;

import com.ssafy.cart.recipe.model.RecipeCommentDto;

public interface RecipeCommentService {
	public RecipeCommentDto searchByCommentSeq(int recipe_comment_seq) throws Exception;
	public List<RecipeCommentDto> searchByRecipeSeq(int recipe_seq) throws Exception;
	public List<RecipeCommentDto> searchByUserSeq(int user_seq) throws Exception;
	public boolean insertRecipeComment(RecipeCommentDto recipeCommentDto) throws Exception;
	public boolean updateRecipeComment(RecipeCommentDto recipeCommentDto) throws Exception;
	public boolean isDeleted(int recipe_comment_seq) throws Exception;
	public boolean deleteRecipeComment(int recipe_comment_seq) throws Exception;
}
