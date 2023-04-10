package com.ssafy.cart.recipe.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.recipe.model.RecipeDetailDto;

@Mapper
public interface RecipeDetailRepo {
	public List<RecipeDetailDto> searchByRecipeSeq(int recipe_seq) throws SQLException;
	public List<RecipeDetailDto> searchByProductSeq(int product_seq) throws SQLException;
	public boolean insert(RecipeDetailDto recipeDetailDto) throws SQLException;
	public boolean update(RecipeDetailDto recipeDetailDto) throws SQLException;
	public boolean delete(int recipe_detail_seq) throws SQLException;
}
