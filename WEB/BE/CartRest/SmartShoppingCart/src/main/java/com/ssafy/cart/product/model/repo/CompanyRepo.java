package com.ssafy.cart.product.model.repo;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.cart.product.model.CompanyDto;

@Mapper
public interface CompanyRepo {
	public CompanyDto searchByName(String company_name) throws SQLException;
	public CompanyDto searchBySeq(int company_seq) throws SQLException;
	public boolean insertCompany(CompanyDto companyDto) throws SQLException;
	public boolean updateCompany(CompanyDto companyDto) throws SQLException;
	public boolean deleteCompany(String company_name) throws SQLException;
}