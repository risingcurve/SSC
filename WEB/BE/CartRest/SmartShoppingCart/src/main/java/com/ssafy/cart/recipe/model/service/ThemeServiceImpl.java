package com.ssafy.cart.recipe.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.recipe.model.ThemeDto;
import com.ssafy.cart.recipe.model.repo.ThemeRepo;

@Service
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ThemeDto searchByName(String theme_name) throws Exception {
		return sqlSession.getMapper(ThemeRepo.class).searchByName(theme_name);
	}

	@Override
	public ThemeDto searchBySeq(int theme_seq) throws Exception {
		return sqlSession.getMapper(ThemeRepo.class).searchBySeq(theme_seq);
	}

	@Override
	public List<ThemeDto> searchList() throws Exception {
		return sqlSession.getMapper(ThemeRepo.class).searchList();
	}

	@Override
	public boolean insert(String theme_name) throws Exception {
		return sqlSession.getMapper(ThemeRepo.class).insert(theme_name);
	}

	@Override
	public boolean update(ThemeDto themeDto) throws Exception {
		return sqlSession.getMapper(ThemeRepo.class).update(themeDto);
	}

	@Override
	public boolean delete(int theme_seq) throws Exception {
		return sqlSession.getMapper(ThemeRepo.class).delete(theme_seq);
	}
}
