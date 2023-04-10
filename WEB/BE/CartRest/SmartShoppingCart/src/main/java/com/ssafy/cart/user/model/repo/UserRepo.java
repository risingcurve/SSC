package com.ssafy.cart.user.model.repo;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.user.model.UserDto;

@Mapper
public interface UserRepo {
	public UserDto userInfoAll(int user_seq) throws SQLException;
	public UserDto userInfo(String user_id) throws SQLException;
	public boolean regist(UserDto userDto) throws SQLException;
	public boolean update(UserDto userDto) throws SQLException;
	public boolean leave(int user_seq) throws SQLException;
	public boolean delete(int user_seq) throws SQLException;
	public UserDto login(UserDto userDto) throws SQLException;
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String user_id) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
