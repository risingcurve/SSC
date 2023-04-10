package com.ssafy.cart.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.product.model.AreaDto;
import com.ssafy.cart.product.model.service.AreaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "구역 관련 API", description = "AreaController")
@Slf4j
@RestController
@RequestMapping("/area")
public class AreaController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private AreaService areaService;
	
	@Operation(summary = "구역 상세 조회", description = "구역의 상세 정보 조회")
	@GetMapping("/{area_seq}")
	public ResponseEntity<?> areaDetail(@PathVariable int area_seq) throws Exception {
		log.info("area areaDetail - 호출");
		AreaDto area = areaService.areaDetail(area_seq);
		if(area != null) {
			return new ResponseEntity<AreaDto>(area, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "구역 목록 조회", description = "전체 구역 목록 조회")
	@GetMapping
	public ResponseEntity<?> areaList() throws Exception {
		log.info("area areaList - 호출");
		List<AreaDto> areas = areaService.areaList();
		if(areas != null) {
			return new ResponseEntity<List<AreaDto>>(areas, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "구역 등록", description = "구역 정보 등록")
	@PostMapping
	public ResponseEntity<?> regist(@RequestBody AreaDto areaDto) throws Exception {
		log.info("area regist - 호출");
		if(areaService.regist(areaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "구역 수정", description = "구역 정보 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody AreaDto areaDto) throws Exception {
		log.info("area update - 호출");
		if(areaService.update(areaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "구역 삭제", description = "구역 정보 삭제")
	@DeleteMapping("/{area_seq}")
	public ResponseEntity<?> delete(@PathVariable("area_seq") int area_seq) throws Exception {
		log.info("area delete - 호출");
		if(areaService.delete(area_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
