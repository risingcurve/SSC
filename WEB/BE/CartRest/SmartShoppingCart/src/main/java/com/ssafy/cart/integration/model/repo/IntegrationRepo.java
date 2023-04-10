package com.ssafy.cart.integration.model.repo;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.integration.model.IntegrationDto;

@Mapper
public interface IntegrationRepo {
	public boolean insert(IntegrationDto inteDto) throws SQLException;
	public boolean insertUser(int user_seq) throws SQLException;
	public boolean insertRecipe(int recipe_seq) throws SQLException;
	public boolean insertProduct(int product_seq) throws SQLException;
	public boolean deleteByUser(int user_seq) throws SQLException;
	public boolean deleteByRecipe(int recipe_seq) throws SQLException;
	public boolean deleteByProduct(int product_seq) throws SQLException;
	public int searchByUserSeq(int user_seq) throws SQLException;
	public int searchByRecipeSeq(int recipe_seq) throws SQLException;
	public int searchByProductSeq(int product_seq) throws SQLException;
}
