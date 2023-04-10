package com.ssafy.cart.cartlist.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.cartlist.model.CartDetailDto;

@Mapper
public interface CartDetailRepo {
	public CartDetailDto searchDetail(int cart_detail_seq) throws SQLException; 
	public List<CartDetailDto> searchDetailList(int cart_seq) throws SQLException;
	public boolean insert(CartDetailDto cartDetailDto) throws SQLException;
	public boolean update(CartDetailDto cartDetailDto) throws SQLException;
	public boolean delete(int cart_detail_seq) throws SQLException;
}
