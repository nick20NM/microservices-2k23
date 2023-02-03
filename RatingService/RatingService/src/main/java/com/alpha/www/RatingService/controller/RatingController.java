package com.alpha.www.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.RatingService.entity.Rating;
import com.alpha.www.RatingService.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String id){
		return ResponseEntity.ok(ratingService.getRatingsByUserId(id));
	}
	
	@GetMapping("/hotels/{id}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String id){
		return ResponseEntity.ok(ratingService.getRatingsByHotelId(id));
	}
	
	
}
