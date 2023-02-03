package com.alpha.www.RatingService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.www.RatingService.entity.Rating;
import com.alpha.www.RatingService.repository.RatingRepository;
import com.alpha.www.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
