package com.alpha.www.HotelService.service;

import java.util.List;

import com.alpha.www.HotelService.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotelById(String id); 
}
