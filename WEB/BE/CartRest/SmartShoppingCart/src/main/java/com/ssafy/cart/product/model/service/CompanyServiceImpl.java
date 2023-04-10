package com.ssafy.cart.product.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cart.product.model.CompanyDto;
import com.ssafy.cart.product.model.repo.CompanyRepo;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public CompanyDto searchByName(String company_name) throws Exception {
		return sqlSession.getMapper(CompanyRepo.class).searchByName(company_name);
	}
	
	@Override
	public CompanyDto searchBySeq(int company_seq) throws Exception {
		return sqlSession.getMapper(CompanyRepo.class).searchBySeq(company_seq);
	}

	@Override
	public boolean insertCompany(CompanyDto companyDto) throws Exception {
		if(companyDto.getCompany_name() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(CompanyRepo.class).insertCompany(companyDto);
	}

	@Override
	public boolean updateCompany(CompanyDto companyDto) throws Exception {
		return sqlSession.getMapper(CompanyRepo.class).updateCompany(companyDto);
	}

	@Override
	public boolean deleteCompany(String company_name) throws Exception {
		return sqlSession.getMapper(CompanyRepo.class).deleteCompany(company_name);
	}
	
	
}
