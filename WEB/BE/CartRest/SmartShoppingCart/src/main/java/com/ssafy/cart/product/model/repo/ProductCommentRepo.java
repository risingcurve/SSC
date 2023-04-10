package com.ssafy.cart.product.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.product.model.ProductCommentDto;

@Mapper
public interface ProductCommentRepo {
	public ProductCommentDto searchComment(int product_comment_seq) throws SQLException;
	public List<ProductCommentDto> searchList(int product_seq) throws SQLException;
	public List<ProductCommentDto> searchListByUserSeq(int user_seq) throws SQLException;
	public boolean insert(ProductCommentDto productCommentDto) throws SQLException;
	public boolean update(ProductCommentDto productCommentDto) throws SQLException;
	public boolean delete(int product_comment_seq) throws SQLException;
}
