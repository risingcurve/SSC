package com.ssafy.cart.product.model.service;

import java.util.List;

import com.ssafy.cart.product.model.ProductCommentDto;

public interface ProductCommentService {
	public ProductCommentDto searchComment(int product_comment_seq) throws Exception;
	public List<ProductCommentDto> searchList(int product_seq) throws Exception;
	public List<ProductCommentDto> searchListByUserSeq(int user_seq) throws Exception;
	public boolean insert(ProductCommentDto productCommentDto) throws Exception;
	public boolean update(ProductCommentDto productCommentDto) throws Exception;
	public boolean delete(int product_comment_seq) throws Exception;
}
