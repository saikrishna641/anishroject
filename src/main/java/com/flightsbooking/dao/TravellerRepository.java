package com.flightsbooking.dao;

import com.flightsbooking.dto.FlightDto;
import com.flightsbooking.dto.TravellerDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TravellerRepository extends CrudRepository<TravellerDto, Long> {
    @Query("select t from TravellerDto t where t.id in (?1)")
    public List<TravellerDto> findTravellersByIds(List<Long> idList);
}
