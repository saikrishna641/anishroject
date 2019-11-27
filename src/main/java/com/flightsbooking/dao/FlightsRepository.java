package com.flightsbooking.dao;

import com.flightsbooking.dto.FlightDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface FlightsRepository extends CrudRepository<FlightDto, Long> {
    @Query("select f from FlightDto f where f.source = ?1 and f.destination = ?2 and f.departureDate  BETWEEN ?3 and ?4")
    public List<FlightDto> findFlightsByCriteria(String source, String destination, Date departureDate,
                                                 Date departureDayEndDate);
}
