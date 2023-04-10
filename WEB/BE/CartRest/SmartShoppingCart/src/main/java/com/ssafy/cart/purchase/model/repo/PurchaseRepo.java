package com.ssafy.cart.purchase.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.purchase.model.PurchaseDto;

@Mapper
public interface PurchaseRepo {
	public List<PurchaseDto> searchList(int user_seq) throws SQLException;
	public boolean regist(PurchaseDto purchaseDto) throws SQLException;
	public boolean updateTotalPrice(int purchase_seq) throws SQLException;
	public boolean delete(int purchase_seq) throws SQLException;
}
