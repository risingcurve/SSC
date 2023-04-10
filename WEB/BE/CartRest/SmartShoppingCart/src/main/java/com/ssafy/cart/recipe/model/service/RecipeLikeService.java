package com.ssafy.cart.recipe.model.service;

import com.ssafy.cart.recipe.model.RecipeLikeDto;

public interface RecipeLikeService {
	public boolean like(RecipeLikeDto recipeLikeDto) throws Exception;
	public boolean cancel(RecipeLikeDto recipeLikeDto) throws Exception;
}
