package com.ssafy.cart.purchase.model.service;

import java.util.List;

import com.ssafy.cart.purchase.model.PurchaseDetailDto;

public interface PurchaseDetailService {
	public List<PurchaseDetailDto> searchByPurchaseSeq(int purchase_seq) throws Exception;
	public boolean insert(PurchaseDetailDto purchaseDetailDto) throws Exception;
}
