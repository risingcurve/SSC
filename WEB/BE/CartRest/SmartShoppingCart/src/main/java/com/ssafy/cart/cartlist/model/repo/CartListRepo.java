package com.ssafy.cart.cartlist.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.cartlist.model.CartListDto;

@Mapper
public interface CartListRepo {
	public CartListDto searchCart(int cart_seq) throws SQLException;
	public List<CartListDto> searchList(int user_seq) throws SQLException;
	public boolean insert(CartListDto cartListDto) throws SQLException;
	public boolean update(CartListDto cartListDto) throws SQLException;
	public boolean updateTotalPrice(int cart_seq) throws SQLException;
	public boolean delete(int cart_seq) throws SQLException;
}
