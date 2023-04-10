package com.ssafy.cart.product.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.product.model.AreaDto;
import com.ssafy.cart.product.model.repo.AreaRepo;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public AreaDto areaDetail(int area_seq) throws Exception {
		return sqlSession.getMapper(AreaRepo.class).areaDetail(area_seq);
	}

	@Override
	public List<AreaDto> areaList() throws Exception {
		return sqlSession.getMapper(AreaRepo.class).areaList();
	}

	@Override
	public boolean regist(AreaDto areaDto) throws Exception {
		return sqlSession.getMapper(AreaRepo.class).regist(areaDto);
	}

	@Override
	public boolean update(AreaDto areaDto) throws Exception {
		return sqlSession.getMapper(AreaRepo.class).update(areaDto);
	}

	@Override
	public boolean delete(int area_seq) throws Exception {
		return sqlSession.getMapper(AreaRepo.class).delete(area_seq);
	}
	
}
