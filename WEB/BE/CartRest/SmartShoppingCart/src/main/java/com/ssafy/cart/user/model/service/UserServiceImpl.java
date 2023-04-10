package com.ssafy.cart.user.model.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.integration.model.repo.IntegrationRepo;
import com.ssafy.cart.user.model.UserDto;
import com.ssafy.cart.user.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDto userInfoAll(int user_seq) throws Exception {
		return sqlSession.getMapper(UserRepo.class).userInfoAll(user_seq);
	}

	@Override
	public UserDto userInfo(String user_id) throws Exception {
		return sqlSession.getMapper(UserRepo.class).userInfo(user_id);
	}

	@Override
	public boolean regist(UserDto userDto) throws Exception {
//		System.out.println(userDto.getUser_id());
		if(userDto.getUser_id() == null || userDto.getUser_pwd() == null || userDto.getUser_name() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(UserRepo.class).regist(userDto);
	}

	@Override
	public boolean insertIntegraion(int user_seq) throws Exception {
		return sqlSession.getMapper(IntegrationRepo.class).insertUser(user_seq);
	}

	@Override
	public boolean update(UserDto userdto) throws Exception {
		return sqlSession.getMapper(UserRepo.class).update(userdto);
	}

	@Override
	public boolean leave(int user_seq) throws Exception {
		return sqlSession.getMapper(UserRepo.class).leave(user_seq);
	}

	@Override
	public boolean delete(int user_seq) throws Exception {
		return sqlSession.getMapper(UserRepo.class).delete(user_seq);
	}

	@Override
	public int integInfo(int user_seq) throws Exception {
		return sqlSession.getMapper(IntegrationRepo.class).searchByUserSeq(user_seq);
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if(userDto.getUser_id() == null || userDto.getUser_pwd() == null) {
			return null;
		}
		return sqlSession.getMapper(UserRepo.class).login(userDto);
	}

	@Override
	public void saveRefreshToken(String user_id, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("token", refreshToken);
		sqlSession.getMapper(UserRepo.class).saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String user_id) throws Exception {
		return sqlSession.getMapper(UserRepo.class).getRefreshToken(user_id);
	}

	@Override
	public void deleRefreshToken(String user_id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("token", null);
		sqlSession.getMapper(UserRepo.class).deleteRefreshToken(map);
	}

//	public static void main(String[] args) throws Exception {
//		UserService usr = new UserServiceImpl();
//		UserDto dto = usr.userInfo("ssafy");
//		System.out.println(dto.getName());
//	}
}
