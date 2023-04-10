package com.ssafy.cart.purchase.model.service;

import java.util.List;

import com.ssafy.cart.purchase.model.PurchaseDto;

public interface PurchaseService {
	public List<PurchaseDto> searchList(int user_seq) throws Exception;
	public boolean regist(PurchaseDto purchaseDto) throws Exception;
	public boolean updateTotalPrice(int purchase_seq) throws Exception;
	public boolean delete(int purchase_seq) throws Exception;
}
