package com.ssafy.cart.product.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.product.model.AreaDto;

@Mapper
public interface AreaRepo {
	public AreaDto areaDetail(int area_seq) throws SQLException;
	public List<AreaDto> areaList() throws SQLException;
	public boolean regist(AreaDto areaDto) throws SQLException;
	public boolean update(AreaDto areaDto) throws SQLException;
	public boolean delete(int area_seq) throws SQLException;
}
