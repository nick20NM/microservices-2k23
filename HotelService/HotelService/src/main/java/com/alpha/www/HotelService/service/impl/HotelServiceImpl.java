package com.alpha.www.HotelService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.www.HotelService.entity.Hotel;
import com.alpha.www.HotelService.exception.ResourceNotFoundException;
import com.alpha.www.HotelService.repository.HotelRepository;
import com.alpha.www.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel not found with id: "+id));
	}

}
