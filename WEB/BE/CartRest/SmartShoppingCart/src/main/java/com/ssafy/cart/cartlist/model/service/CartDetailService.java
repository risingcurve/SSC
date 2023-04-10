package com.ssafy.cart.cartlist.model.service;

import java.util.List;

import com.ssafy.cart.cartlist.model.CartDetailDto;

public interface CartDetailService {
	public CartDetailDto searchDetail(int cart_detail_seq) throws Exception; 
	public List<CartDetailDto> searchDetailList(int cart_seq) throws Exception;
	public boolean insert(CartDetailDto cartDetailDto) throws Exception;
	public boolean update(CartDetailDto cartDetailDto) throws Exception;
	public boolean delete(int cart_detail_seq) throws Exception;
}
