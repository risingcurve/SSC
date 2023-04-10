package com.ssafy.cart.product.model.service;

import java.util.List;

import com.ssafy.cart.product.model.ProductDto;
import com.ssafy.cart.product.model.ProductParamDto;
import com.ssafy.cart.search.model.SearchParamDto;

public interface ProductService {
	public ProductDto searchBySeq(int product_seq) throws Exception;
	public ProductDto searchByName(String product_name) throws Exception;
	public List<ProductDto> productList(SearchParamDto searchParamDto) throws Exception;
	public List<ProductDto> productDeletedList(ProductParamDto productParamDto) throws Exception;
	public boolean regist(ProductDto productDto) throws Exception;
	public boolean update(ProductDto productDto) throws Exception;
	public boolean remove(int product_seq) throws Exception;
	public boolean delete(int product_seq) throws Exception;
	public boolean insertIntegration(int product_seq) throws Exception;
	public int integInfo(int product_seq) throws Exception;
}
