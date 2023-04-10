package com.ssafy.cart.recipe.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.integration.model.repo.IntegrationRepo;
import com.ssafy.cart.recipe.model.RecipeDto;
import com.ssafy.cart.recipe.model.repo.RecipeRepo;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<RecipeDto> searchListByTheme(int theme_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).searchListByTheme(theme_seq);
	}
	
	@Override
	public List<RecipeDto> searchListByProductSeq(int product_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).searchListByProductSeq(product_seq);
	}
	
	@Override
	public List<RecipeDto> searchListByUserSeq(int user_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).searchListByUserSeq(user_seq);
	}
	
	@Override
	public RecipeDto detailByRecipeName(String recipe_name) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).detailByRecipeName(recipe_name);
	}

	@Override
	public RecipeDto detailByRecipeSeq(int recipe_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).detailByRecipeSeq(recipe_seq);
	}

	@Override
	public boolean regist(RecipeDto recipeDto) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).regist(recipeDto);
	}
	
	@Override
	public boolean update(RecipeDto recipeDto) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).update(recipeDto);
	}

	@Override
	public boolean updateLikeCnt(int recipe_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).updateLikeCnt(recipe_seq);
	}

	@Override
	public boolean isDeleted(int recipe_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).isDeleted(recipe_seq);
	}

	@Override
	public boolean delete(int recipe_seq) throws Exception {
		return sqlSession.getMapper(RecipeRepo.class).delete(recipe_seq);
	}

	@Override
	public boolean insertIntegration(int recipe_seq) throws Exception {
		return sqlSession.getMapper(IntegrationRepo.class).insertRecipe(recipe_seq);
	}

	@Override
	public int integInfo(int recipe_seq) throws Exception {
		return sqlSession.getMapper(IntegrationRepo.class).searchByRecipeSeq(recipe_seq);
	}
	
}
