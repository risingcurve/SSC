package com.ssafy.cart.recipe.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.recipe.model.RecipeDetailDto;
import com.ssafy.cart.recipe.model.repo.RecipeDetailRepo;

@Service
public class RecipeDetailServiceImpl implements RecipeDetailService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<RecipeDetailDto> searchByRecipeSeq(int recipe_seq) throws Exception {
		return sqlSession.getMapper(RecipeDetailRepo.class).searchByRecipeSeq(recipe_seq);
	}
	
	@Override
	public List<RecipeDetailDto> searchByProductSeq(int product_seq) throws Exception {
		return sqlSession.getMapper(RecipeDetailRepo.class).searchByProductSeq(product_seq);
	}

	@Override
	public boolean insert(RecipeDetailDto recipeDetailDto) throws Exception {
		return sqlSession.getMapper(RecipeDetailRepo.class).insert(recipeDetailDto);
	}

	@Override
	public boolean update(RecipeDetailDto recipeDetailDto) throws Exception {
		return sqlSession.getMapper(RecipeDetailRepo.class).update(recipeDetailDto);
	}

	@Override
	public boolean delete(int recipe_detail_seq) throws Exception {
		return sqlSession.getMapper(RecipeDetailRepo.class).delete(recipe_detail_seq);
	}
	
}
