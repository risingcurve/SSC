package com.ssafy.cart.purchase.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.purchase.model.PurchaseDetailDto;
import com.ssafy.cart.purchase.model.repo.PurchaseDetailRepo;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PurchaseDetailDto> searchByPurchaseSeq(int purchase_seq) throws Exception {
		return sqlSession.getMapper(PurchaseDetailRepo.class).searchByPurchaseSeq(purchase_seq);
	}

	@Override
	public boolean insert(PurchaseDetailDto purchaseDetailDto) throws Exception {
		return sqlSession.getMapper(PurchaseDetailRepo.class).insert(purchaseDetailDto);
	}

}
