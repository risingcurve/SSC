package com.ssafy.cart.image.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cart.image.model.ImageDto;
import com.ssafy.cart.image.model.service.ImageService;
import com.ssafy.cart.product.model.service.ProductService;
import com.ssafy.cart.recipe.model.service.RecipeService;
import com.ssafy.cart.user.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "이미지 관련 API", description = "ImageController")
@Slf4j
@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Operation(summary = "이미지 출력", description = "통합 일련번호(integ_seq)에 해당하는 이미지 출력")
	@GetMapping(value ="/{integ_seq}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> download(@PathVariable("integ_seq") int integ_seq) throws Exception {
		log.info("Image download - 호출");
		log.info("inget_seq : {}", integ_seq);
		FileInputStream fis = null;
		ImageDto image = imageService.search(integ_seq);
		String fileDir = image.getSave_folder() + "/" + image.getSave_name();
		log.info("fileDir : {}", fileDir);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(fileDir);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try{
            while((readCount = fis.read(buffer)) != -1){
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch(IOException e){
            throw new RuntimeException("File Error");
        }
        return new ResponseEntity<byte[]>(fileArray, HttpStatus.OK);
	}
	
	@Operation(summary = "회원 이미지 출력", description = "회원 일련번호(user_seq)에 해당하는 이미지 출력")
	@GetMapping(value ="/user/{user_seq}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> downloadUser(@PathVariable("user_seq") int user_seq) throws Exception {
		log.info("User Image download - 호출");
		log.info("user_seq : {}", user_seq);
		FileInputStream fis = null;
		ImageDto image = imageService.search(userService.integInfo(user_seq));
		String fileDir = image.getSave_folder() + "/" + image.getSave_name();
		log.info("fileDir : {}", fileDir);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(fileDir);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try{
            while((readCount = fis.read(buffer)) != -1){
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch(IOException e){
            throw new RuntimeException("File Error");
        }
        return new ResponseEntity<byte[]>(fileArray, HttpStatus.OK);
	}
	
	@Operation(summary = "상품 이미지 출력", description = "상품 일련번호(product_seq)에 해당하는 이미지 출력")
	@GetMapping(value ="/product/{product_seq}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> downloadProduct(@PathVariable("product_seq") int product_seq) throws Exception {
		log.info("Product Image download - 호출");
		log.info("product_seq : {}", product_seq);
		FileInputStream fis = null;
		ImageDto image = imageService.search(productService.integInfo(product_seq));
		String fileDir = image.getSave_folder() + "/" + image.getSave_name();
		log.info("fileDir : {}", fileDir);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(fileDir);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try{
            while((readCount = fis.read(buffer)) != -1){
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch(IOException e){
            throw new RuntimeException("File Error");
        }
        return new ResponseEntity<byte[]>(fileArray, HttpStatus.OK);
	}
	
	@Operation(summary = "레시피 대표 이미지 출력", description = "레시피 일련번호(recipe_seq)에 해당하는 이미지 출력")
	@GetMapping(value ="/recipe/{recipe_seq}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> downloadRecipe(@PathVariable("recipe_seq") int recipe_seq) throws Exception {
		log.info("Recipe Image download - 호출");
		log.info("recipe_seq : {}", recipe_seq);
		
		ImageDto image = imageService.searchList(recipeService.integInfo(recipe_seq)).get(0);
		
		FileInputStream fis = null;
		String fileDir = image.getSave_folder() + "/" + image.getSave_name();
		log.info("fileDir : {}", fileDir);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(fileDir);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try{
            while((readCount = fis.read(buffer)) != -1){
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch(IOException e){
            throw new RuntimeException("File Error");
        }
		
        return new ResponseEntity<byte[]>(fileArray, HttpStatus.OK);
	}
	
	@Operation(summary = "레시피 이미지 목록 출력", description = "레시피 일련번호(recipe_seq)에 해당하는 이미지 출력")
	@GetMapping(value ="/recipe/list/{recipe_seq}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> downloadRecipeList(@PathVariable("recipe_seq") int recipe_seq) throws Exception {
		log.info("Recipe Image download - 호출");
		log.info("recipe_seq : {}", recipe_seq);
		
		List<ImageDto> images = imageService.searchList(recipeService.integInfo(recipe_seq));
		List<byte[]> recipeImages = new ArrayList<>();
		
		for(ImageDto image : images) {
			FileInputStream fis = null;
			String fileDir = image.getSave_folder() + "/" + image.getSave_name();
			log.info("fileDir : {}", fileDir);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				fis = new FileInputStream(fileDir);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			int readCount = 0;
	        byte[] buffer = new byte[1024];
	        byte[] fileArray = null;

	        try{
	            while((readCount = fis.read(buffer)) != -1){
	                baos.write(buffer, 0, readCount);
	            }
	            fileArray = baos.toByteArray();
	            fis.close();
	            baos.close();
	            recipeImages.add(fileArray);
	        } catch(IOException e){
	            throw new RuntimeException("File Error");
	        }
		}
		
        return new ResponseEntity<List<byte[]>>(recipeImages, HttpStatus.OK);
	}
}
