package com.ssafy.cart.cartlist.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.cartlist.model.CartListDto;
import com.ssafy.cart.cartlist.model.repo.CartListRepo;

@Service
public class CartListServiceImpl implements CartListService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public CartListDto searchCart(int cart_seq) throws Exception {
		return sqlSession.getMapper(CartListRepo.class).searchCart(cart_seq);
	}

	@Override
	public List<CartListDto> searchList(int user_seq) throws Exception {
		return sqlSession.getMapper(CartListRepo.class).searchList(user_seq);
	}

	@Override
	public boolean insert(CartListDto cartListDto) throws Exception {
		return sqlSession.getMapper(CartListRepo.class).insert(cartListDto);
	}

	@Override
	public boolean update(CartListDto cartListDto) throws Exception {
		return sqlSession.getMapper(CartListRepo.class).update(cartListDto);
	}

	@Override
	public boolean delete(int cart_seq) throws Exception {
		return sqlSession.getMapper(CartListRepo.class).delete(cart_seq);
	}

}
