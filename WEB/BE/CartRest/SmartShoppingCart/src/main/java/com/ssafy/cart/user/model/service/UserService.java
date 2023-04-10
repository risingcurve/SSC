package com.ssafy.cart.user.model.service;

import com.ssafy.cart.user.model.UserDto;

public interface UserService {
	public UserDto userInfoAll(int user_seq) throws Exception;
	public UserDto userInfo(String user_id) throws Exception;
	public int integInfo(int user_seq) throws Exception;
	public boolean regist(UserDto userDto) throws Exception;
	public boolean insertIntegraion(int user_seq) throws Exception;
	public boolean update(UserDto userdto) throws Exception;
	public boolean leave(int user_seq) throws Exception;
	public boolean delete(int user_seq) throws Exception;
	public UserDto login(UserDto userDto) throws Exception;
	public void saveRefreshToken(String user_id, String refreshToken) throws Exception;
	public Object getRefreshToken(String user_id) throws Exception;
	public void deleRefreshToken(String user_id) throws Exception;
}
