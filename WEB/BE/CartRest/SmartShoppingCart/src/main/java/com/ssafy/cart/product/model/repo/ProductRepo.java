package com.ssafy.cart.product.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.product.model.ProductDto;
import com.ssafy.cart.product.model.ProductParamDto;
import com.ssafy.cart.search.model.SearchParamDto;

@Mapper
public interface ProductRepo {
	public ProductDto searchBySeq(int product_seq) throws SQLException;
	public ProductDto searchByName(String product_name) throws SQLException;
	public List<ProductDto> productList(SearchParamDto searchParamDto) throws SQLException;
	public List<ProductDto> productDeletedList(ProductParamDto productParamDto) throws SQLException;
	public boolean regist(ProductDto productDto) throws SQLException;
	public boolean update(ProductDto productDto) throws SQLException;
	public boolean remove(int product_seq) throws SQLException;
	public boolean delete(int product_seq) throws SQLException;
}
