package com.flightsbooking.dao;

import com.flightsbooking.dto.FlightDto;
import com.flightsbooking.dto.ItineraryDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ItineraryRepository extends CrudRepository<ItineraryDto, Long> {

}
