package com.ssafy.cart.cartlist.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.cartlist.model.CartDetailDto;
import com.ssafy.cart.cartlist.model.repo.CartDetailRepo;
import com.ssafy.cart.cartlist.model.repo.CartListRepo;

@Service
public class CartDetailServiceImpl implements CartDetailService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public CartDetailDto searchDetail(int cart_detail_seq) throws Exception {
		return sqlSession.getMapper(CartDetailRepo.class).searchDetail(cart_detail_seq);
	}

	@Override
	public List<CartDetailDto> searchDetailList(int cart_seq) throws Exception {
		return sqlSession.getMapper(CartDetailRepo.class).searchDetailList(cart_seq);
	}

	@Override
	public boolean insert(CartDetailDto cartDetailDto) throws Exception {
		sqlSession.getMapper(CartDetailRepo.class).insert(cartDetailDto);
		return sqlSession.getMapper(CartListRepo.class).updateTotalPrice(cartDetailDto.getCart_seq());
	}

	@Override
	public boolean update(CartDetailDto cartDetailDto) throws Exception {
		return sqlSession.getMapper(CartDetailRepo.class).update(cartDetailDto);
	}

	@Override
	public boolean delete(int cart_detail_seq) throws Exception {
		CartDetailDto detail = sqlSession.getMapper(CartDetailRepo.class).searchDetail(cart_detail_seq);
		sqlSession.getMapper(CartDetailRepo.class).delete(cart_detail_seq); 
		return sqlSession.getMapper(CartListRepo.class).updateTotalPrice(detail.getCart_seq());
	}

}
