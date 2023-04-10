package com.ssafy.cart.cartlist.model.service;

import java.util.List;

import com.ssafy.cart.cartlist.model.CartListDto;

public interface CartListService {
	public CartListDto searchCart(int cart_seq) throws Exception;
	public List<CartListDto> searchList(int user_seq) throws Exception;
	public boolean insert(CartListDto cartListDto) throws Exception;
	public boolean update(CartListDto cartListDto) throws Exception;
	public boolean delete(int cart_seq) throws Exception;
}
