package com.ssafy.cart.product.model.service;

import com.ssafy.cart.product.model.CompanyDto;

public interface CompanyService {
	public CompanyDto searchByName(String company_name) throws Exception;
	public CompanyDto searchBySeq(int company_seq) throws Exception;
	public boolean insertCompany(CompanyDto companyDto) throws Exception;
	public boolean updateCompany(CompanyDto companyDto) throws Exception;
	public boolean deleteCompany(String company_name) throws Exception;
}
