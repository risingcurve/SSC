package com.ssafy.cart.image.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.image.model.ImageDto;
import com.ssafy.cart.image.model.repo.ImageRepo;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean insert(ImageDto imageDto) throws Exception {
		return sqlSession.getMapper(ImageRepo.class).insert(imageDto);
	}

	@Override
	public boolean delete(int image_seq) throws Exception {
		return sqlSession.getMapper(ImageRepo.class).delete(image_seq);
	}
	
	@Override
	public ImageDto search(int integ_seq) throws Exception {
		return sqlSession.getMapper(ImageRepo.class).search(integ_seq);
	}

	@Override
	public List<ImageDto> searchList(int integ_seq) throws Exception {
		return sqlSession.getMapper(ImageRepo.class).searchList(integ_seq);
	}

}
