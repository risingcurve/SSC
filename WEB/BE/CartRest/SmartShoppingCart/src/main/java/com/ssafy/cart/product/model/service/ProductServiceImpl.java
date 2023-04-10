package com.ssafy.cart.product.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.integration.model.repo.IntegrationRepo;
import com.ssafy.cart.product.model.ProductDto;
import com.ssafy.cart.product.model.ProductParamDto;
import com.ssafy.cart.product.model.repo.ProductRepo;
import com.ssafy.cart.search.model.SearchParamDto;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ProductDto searchBySeq(int product_seq) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).searchBySeq(product_seq);
	}
	
	@Override
	public ProductDto searchByName(String product_name) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).searchByName(product_name);
	}

	@Override
	public List<ProductDto> productList(SearchParamDto searchParamDto) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).productList(searchParamDto);
	}

	@Override
	public List<ProductDto> productDeletedList(ProductParamDto productParamDto) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).productDeletedList(productParamDto);
	}

	@Override
	public boolean regist(ProductDto productDto) throws Exception {
		if(productDto.getProduct_name() == null) { // 상품 이름 필수 입력
			throw new Exception();
		}
		return sqlSession.getMapper(ProductRepo.class).regist(productDto);
	}

	@Override
	public boolean update(ProductDto productDto) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).update(productDto);
	}

	@Override
	public boolean delete(int product_seq) throws Exception {
		sqlSession.getMapper(IntegrationRepo.class).deleteByProduct(product_seq);
		return sqlSession.getMapper(ProductRepo.class).delete(product_seq);
	}

	@Override
	public boolean remove(int product_seq) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).remove(product_seq);
	}

	@Override
	public boolean insertIntegration(int product_seq) throws Exception {
		return sqlSession.getMapper(IntegrationRepo.class).insertProduct(product_seq);
	}

	@Override
	public int integInfo(int product_seq) throws Exception {
		return sqlSession.getMapper(IntegrationRepo.class).searchByProductSeq(product_seq);
	}
	
}
