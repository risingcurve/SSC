package com.ssafy.cart.recipe.model.repo;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.recipe.model.RecipeLikeDto;

@Mapper
public interface RecipeLikeRepo {
	public boolean like(RecipeLikeDto recipeLikeDto) throws SQLException;
	public boolean cancel(RecipeLikeDto recipeLikeDto) throws SQLException;
}
