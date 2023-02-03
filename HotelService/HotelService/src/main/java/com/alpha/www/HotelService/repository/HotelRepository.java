package com.alpha.www.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.www.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
