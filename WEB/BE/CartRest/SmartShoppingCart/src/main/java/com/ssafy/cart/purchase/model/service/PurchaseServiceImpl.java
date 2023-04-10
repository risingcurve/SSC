package com.ssafy.cart.purchase.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.purchase.model.PurchaseDto;
import com.ssafy.cart.purchase.model.repo.PurchaseRepo;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PurchaseDto> searchList(int user_seq) throws Exception {
		return sqlSession.getMapper(PurchaseRepo.class).searchList(user_seq);
	}

	@Override
	public boolean regist(PurchaseDto purchaseDto) throws Exception {
		return sqlSession.getMapper(PurchaseRepo.class).regist(purchaseDto);
	}

	@Override
	public boolean updateTotalPrice(int purchase_seq) throws Exception {
		return sqlSession.getMapper(PurchaseRepo.class).updateTotalPrice(purchase_seq);
	}

	@Override
	public boolean delete(int purchase_seq) throws Exception {
		return sqlSession.getMapper(PurchaseRepo.class).delete(purchase_seq);
	}
	
}
