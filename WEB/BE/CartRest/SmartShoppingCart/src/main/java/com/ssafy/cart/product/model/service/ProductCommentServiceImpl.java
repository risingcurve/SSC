package com.ssafy.cart.product.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.product.model.ProductCommentDto;
import com.ssafy.cart.product.model.repo.ProductCommentRepo;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ProductCommentDto searchComment(int product_comment_seq) throws Exception {
		return sqlSession.getMapper(ProductCommentRepo.class).searchComment(product_comment_seq);
	}

	@Override
	public List<ProductCommentDto> searchList(int product_seq) throws Exception {
		return sqlSession.getMapper(ProductCommentRepo.class).searchList(product_seq);
	}
	
	@Override
	public List<ProductCommentDto> searchListByUserSeq(int user_seq) throws Exception {
		return sqlSession.getMapper(ProductCommentRepo.class).searchListByUserSeq(user_seq);
	}

	@Override
	public boolean insert(ProductCommentDto productCommentDto) throws Exception {
		return sqlSession.getMapper(ProductCommentRepo.class).insert(productCommentDto);
	}

	@Override
	public boolean update(ProductCommentDto productCommentDto) throws Exception {
		return sqlSession.getMapper(ProductCommentRepo.class).update(productCommentDto);
	}

	@Override
	public boolean delete(int product_comment_seq) throws Exception {
		return sqlSession.getMapper(ProductCommentRepo.class).delete(product_comment_seq);
	}

}
