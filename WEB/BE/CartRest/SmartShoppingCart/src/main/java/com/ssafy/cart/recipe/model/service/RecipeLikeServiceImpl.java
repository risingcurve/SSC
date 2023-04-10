package com.ssafy.cart.recipe.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.recipe.model.RecipeLikeDto;
import com.ssafy.cart.recipe.model.repo.RecipeLikeRepo;
import com.ssafy.cart.recipe.model.repo.RecipeRepo;

@Service
public class RecipeLikeServiceImpl implements RecipeLikeService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean like(RecipeLikeDto recipeLikeDto) throws Exception {
		sqlSession.getMapper(RecipeLikeRepo.class).like(recipeLikeDto);
		return sqlSession.getMapper(RecipeRepo.class).updateLikeCnt(recipeLikeDto.getRecipe_seq());
	}

	@Override
	public boolean cancel(RecipeLikeDto recipeLikeDto) throws Exception {
		sqlSession.getMapper(RecipeLikeRepo.class).cancel(recipeLikeDto);
		return sqlSession.getMapper(RecipeRepo.class).updateLikeCnt(recipeLikeDto.getRecipe_seq());
	}
	
}
