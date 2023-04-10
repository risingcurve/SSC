package com.ssafy.cart.image.model.service;

import java.util.List;

import com.ssafy.cart.image.model.ImageDto;

public interface ImageService {
	public boolean insert(ImageDto imageDto) throws Exception;
	public boolean delete(int image_seq) throws Exception;
	public ImageDto search(int integ_seq) throws Exception;
	public List<ImageDto> searchList(int integ_seq) throws Exception;
}
