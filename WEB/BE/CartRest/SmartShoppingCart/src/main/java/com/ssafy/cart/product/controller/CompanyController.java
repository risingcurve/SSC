package com.ssafy.cart.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.product.model.CompanyDto;
import com.ssafy.cart.product.model.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "회사 관련 API", description = "CompanyController")
@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private CompanyService companyService;
	
	@Operation(summary = "회사 조회", description = "회사 이름으로 회사 조회")
	@GetMapping("/name/{company_name}")
	public ResponseEntity<?> searchByName(@PathVariable("company_name") String company_name) throws Exception {
		log.info("searchByName - 호출");
		CompanyDto company = companyService.searchByName(company_name);
		if(company != null) {
			return new ResponseEntity<CompanyDto>(company, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회사 조회", description = "회사 일련번호로 회사 조회")
	@GetMapping("/{company_seq}")
	public ResponseEntity<?> searchBySeq(@PathVariable("company_seq") int company_seq) throws Exception {
		log.info("searchBySeq - 호출");
		CompanyDto company = companyService.searchBySeq(company_seq);
		if(company != null) {
			return new ResponseEntity<CompanyDto>(company, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회사 등록", description = "회사 등록")
	@PostMapping
	public ResponseEntity<?> insertCompany(CompanyDto companyDto) throws Exception {
		log.info("insertCompany - 호출");
		if(companyService.insertCompany(companyDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회사 수정", description = "회사 정보 수정")
	@PutMapping
	public ResponseEntity<?> updateCompany(CompanyDto companyDto) throws Exception {
		log.info("updateCompany - 호출");
		if(companyService.updateCompany(companyDto)) { // company_seq가 있어야함
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "회사 삭제", description = "회사 정보 삭제")
	@DeleteMapping("/{company_name}")
	public ResponseEntity<?> deleteCompany(@PathVariable("company_name") String company_name) throws Exception {
		log.info("deleteCompany - 호출");
		if(companyService.deleteCompany(company_name)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
