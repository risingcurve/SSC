package com.ssafy.cart.purchase.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.purchase.model.PurchaseDetailDto;

@Mapper
public interface PurchaseDetailRepo {
	public List<PurchaseDetailDto> searchByPurchaseSeq(int purchase_seq) throws SQLException;
	public boolean insert(PurchaseDetailDto purchaseDetailDto) throws SQLException;
}
