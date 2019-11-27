package com.flightsbooking.dao;

import com.flightsbooking.dto.CustomerDto;
import com.flightsbooking.dto.FlightDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerDto, Long> {

}
