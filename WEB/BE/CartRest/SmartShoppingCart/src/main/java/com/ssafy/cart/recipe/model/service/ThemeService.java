package com.ssafy.cart.recipe.model.service;

import java.util.List;

import com.ssafy.cart.recipe.model.ThemeDto;

public interface ThemeService {
	public ThemeDto searchByName(String theme_name) throws Exception;
	public ThemeDto searchBySeq(int theme_seq) throws Exception;
	public List<ThemeDto> searchList() throws Exception;
	public boolean insert(String theme_name) throws Exception;
	public boolean update(ThemeDto themeDto) throws Exception;
	public boolean delete(int theme_seq) throws Exception;
}
