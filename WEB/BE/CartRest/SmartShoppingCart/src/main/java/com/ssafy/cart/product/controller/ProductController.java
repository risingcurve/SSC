package com.ssafy.cart.product.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.cart.image.model.ImageDto;
import com.ssafy.cart.image.model.service.ImageService;
import com.ssafy.cart.product.model.ProductDto;
import com.ssafy.cart.product.model.ProductParamDto;
import com.ssafy.cart.product.model.service.ProductService;
import com.ssafy.cart.search.model.SearchParamDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "상품 관련 API", description = "ProductController")
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ImageService imageService;
	
	@Operation(summary = "상품 한개 조회", description = "상품 일련번호로 모든 정보 조회")
	@GetMapping("/searchbyseq/{product_seq}")
	public ResponseEntity<?> searchBySeq(@PathVariable("product_seq") int product_seq) throws Exception {
		log.info("searchBySeq - 호출");
		ProductDto product = productService.searchBySeq(product_seq);
		if(product != null) {
			List<ImageDto> images = imageService.searchList(productService.integInfo(product_seq));
			product.setImageInfos(images);
			return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 한개 조회", description = "상품 일련번호로 모든 정보 조회")
	@GetMapping("/searchbyname/{product_name}")
	public ResponseEntity<?> searchByName(@PathVariable("product_name") String product_name) throws Exception {
		log.info("searchByName - 호출");
		ProductDto product = productService.searchByName(product_name);
		if(product != null) {
			List<ImageDto> images = imageService.searchList(productService.integInfo(product.getProduct_seq()));
			product.setImageInfos(images);
			return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 목록 조회", description = "삭제되지 않은 상품 목록 조회")
	@GetMapping
	public ResponseEntity<List<ProductDto>> productList(SearchParamDto searchParamDto) throws Exception {
		log.info("productList - 호출");
//		log.debug(productParamDto.getWord());
		List<ProductDto> products = productService.productList(searchParamDto);
		for(ProductDto product : products) {
			List<ImageDto> images = imageService.searchList(productService.integInfo(product.getProduct_seq()));
			product.setImageInfos(images);
		}
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	
	@Operation(summary = "상품 삭제 목록 조회", description = "삭제 처리된 상품 목록 조회")
	@GetMapping("/deletedlist")
	public ResponseEntity<List<ProductDto>> productDeletedList(ProductParamDto productParamDto) throws Exception {
		log.info("productDeletedList - 호출");
//		log.debug(productParamDto.getWord());
		return new ResponseEntity<List<ProductDto>>(productService.productDeletedList(productParamDto), HttpStatus.OK);
	}
	
	@Operation(summary = "상품 등록", description = "상품 등록")
	@PostMapping
	public ResponseEntity<?> regist(@Value("${file.path.upload-product}") String filePath, @RequestParam(name = "upfile", required = false) MultipartFile[] files, ProductDto productDto) throws Exception {
		log.info("product regist - 호출");
		if(productService.regist(productDto)) {
			ProductDto product = productService.searchByName(productDto.getProduct_name());
//			IntegrationDto inteDto = new IntegrationDto(null, null, product.getProduct_seq());
			productService.insertIntegration(product.getProduct_seq());
			int integ = productService.integInfo(product.getProduct_seq());
			log.info("{}", integ);
			log.debug("MultipartFile.isEmpty : {}", files[0].isEmpty());
			if(!files[0].isEmpty()) {
				log.info("image upload");
//				String today = new SimpleDateFormat("yyMMdd").format(new Date());
				String saveFolder = filePath;
				log.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if(!folder.exists()) {
					folder.mkdir();
					log.debug("폴더 생성!");
				}
				
				List<ImageDto> imageInfos = new ArrayList<ImageDto>();
				for(MultipartFile mfile : files) {
					ImageDto imageDto = new ImageDto();
					String originalFileName = mfile.getOriginalFilename();
					if(!originalFileName.isEmpty()) {
						log.info("originalFileName : {}", originalFileName);
						String saveFileName = product.getProduct_name() + originalFileName.substring(originalFileName.lastIndexOf('.'));
						imageDto.setInteg_seq(integ);
						imageDto.setSave_name(saveFileName);
						imageDto.setOrigin_name(originalFileName);
						imageDto.setSave_folder(saveFolder);
						imageService.insert(imageDto);
						mfile.transferTo(new File(folder, saveFileName));
					}
					imageInfos.add(imageDto);
				}
				product.setImageInfos(imageInfos);
			}
			productService.update(product);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 수정", description = "상품 수정")
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ProductDto productDto) throws Exception {
		log.info("update - 호출");
		if(productService.update(productDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 삭제 처리", description = "상품 삭제 처리")
	@PutMapping("/{product_seq}")
	public ResponseEntity<?> remove(@PathVariable("product_seq") int product_seq) throws Exception {
		log.info("remove - 호출");
		if(productService.remove(product_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@Operation(summary = "상품 삭제", description = "상품 삭제")
	@DeleteMapping("/{product_seq}")
	public ResponseEntity<?> delete(@PathVariable("product_seq") int product_seq) throws Exception {
		log.info("delete - 호출");
		if(productService.delete(product_seq)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
}
