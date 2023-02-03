package com.alpha.www.RatingService.service;

import java.util.List;

import com.alpha.www.RatingService.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getRatingsByHotelId(String hotelId);
}
