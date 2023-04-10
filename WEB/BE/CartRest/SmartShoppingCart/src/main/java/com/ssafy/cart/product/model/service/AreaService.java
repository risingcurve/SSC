package com.ssafy.cart.product.model.service;

import java.util.List;

import com.ssafy.cart.product.model.AreaDto;

public interface AreaService {
	public AreaDto areaDetail(int area_seq) throws Exception;
	public List<AreaDto> areaList() throws Exception;
	public boolean regist(AreaDto areaDto) throws Exception;
	public boolean update(AreaDto areaDto) throws Exception;
	public boolean delete(int area_seq) throws Exception;
}
