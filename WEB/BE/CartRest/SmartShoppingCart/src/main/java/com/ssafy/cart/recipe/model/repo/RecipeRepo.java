package com.ssafy.cart.recipe.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.recipe.model.RecipeDto;

@Mapper
public interface RecipeRepo {
	public List<RecipeDto> searchListByTheme(int theme_seq) throws SQLException;
	public List<RecipeDto> searchListByProductSeq(int product_seq) throws SQLException;
	public List<RecipeDto> searchListByUserSeq(int user_seq) throws SQLException;
	public RecipeDto detailByRecipeName(String recipe_name) throws SQLException;
	public RecipeDto detailByRecipeSeq(int recipe_seq) throws SQLException;
	public boolean regist(RecipeDto recipeDto) throws SQLException;
	public boolean update(RecipeDto recipeDto) throws SQLException;
	public boolean updateLikeCnt(int recipe_seq) throws SQLException;
	public boolean isDeleted(int recipe_seq) throws SQLException;
	public boolean delete(int recipe_seq) throws SQLException;
}
