package com.ssafy.cart.recipe.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.recipe.model.ThemeDto;

@Mapper
public interface ThemeRepo {
	public ThemeDto searchByName(String theme_name) throws SQLException;
	public ThemeDto searchBySeq(int theme_seq) throws SQLException;
	public List<ThemeDto> searchList() throws SQLException;
	public boolean insert(String theme_name) throws SQLException;
	public boolean update(ThemeDto themeDto) throws SQLException;
	public boolean delete(int theme_seq) throws SQLException;
}
