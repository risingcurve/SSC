package com.ssafy.cart.recipe.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.recipe.model.RecipeCommentDto;

@Mapper
public interface RecipeCommentRepo {
	public RecipeCommentDto searchByCommentSeq(int recipe_comment_seq) throws SQLException;
	public List<RecipeCommentDto> searchByRecipeSeq(int recipe_seq) throws SQLException;
	public List<RecipeCommentDto> searchByUserSeq(int user_seq) throws SQLException;
	public boolean insertRecipeComment(RecipeCommentDto recipeCommentDto) throws SQLException;
	public boolean updateRecipeComment(RecipeCommentDto recipeCommentDto) throws SQLException;
	public boolean isDeleted(int recipe_comment_seq) throws SQLException;
	public boolean deleteRecipeComment(int recipe_comment_seq) throws SQLException;
}
