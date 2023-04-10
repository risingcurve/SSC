package com.ssafy.cart.search.model.repo;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchRepo {
	public Map<String, Object> search(String word) throws SQLException;
}
