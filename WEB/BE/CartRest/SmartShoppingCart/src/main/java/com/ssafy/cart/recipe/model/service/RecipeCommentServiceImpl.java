package com.ssafy.cart.recipe.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.recipe.model.RecipeCommentDto;
import com.ssafy.cart.recipe.model.repo.RecipeCommentRepo;

@Service
public class RecipeCommentServiceImpl implements RecipeCommentService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public RecipeCommentDto searchByCommentSeq(int recipe_comment_seq) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).searchByCommentSeq(recipe_comment_seq);
	}

	@Override
	public List<RecipeCommentDto> searchByRecipeSeq(int recipe_seq) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).searchByRecipeSeq(recipe_seq);
	}

	@Override
	public List<RecipeCommentDto> searchByUserSeq(int user_seq) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).searchByUserSeq(user_seq);
	}

	@Override
	public boolean insertRecipeComment(RecipeCommentDto recipeCommentDto) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).insertRecipeComment(recipeCommentDto);
	}

	@Override
	public boolean updateRecipeComment(RecipeCommentDto recipeCommentDto) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).updateRecipeComment(recipeCommentDto);
	}

	@Override
	public boolean isDeleted(int recipe_comment_seq) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).isDeleted(recipe_comment_seq);
	}

	@Override
	public boolean deleteRecipeComment(int recipe_comment_seq) throws Exception {
		return sqlSession.getMapper(RecipeCommentRepo.class).deleteRecipeComment(recipe_comment_seq);
	}
	
	
}
