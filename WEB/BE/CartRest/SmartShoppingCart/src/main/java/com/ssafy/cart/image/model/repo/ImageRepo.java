package com.ssafy.cart.image.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.image.model.ImageDto;

@Mapper
public interface ImageRepo {
	public boolean insert(ImageDto imageDto) throws SQLException;
	public boolean delete(int image_seq) throws SQLException;
	public ImageDto search(int integ_seq) throws SQLException;
	public List<ImageDto> searchList(int integ_seq) throws SQLException;
}
