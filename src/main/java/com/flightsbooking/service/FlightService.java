package com.flightsbooking.service;

import com.flightsbooking.form.FlightForm;
import com.flightsbooking.form.FlightSearchCriteria;
import com.flightsbooking.form.PaymentForm;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FlightService {

    List<FlightForm> searchFLights(FlightSearchCriteria flightSearchCriteria);

    String bookFlight(String flightId, String customerId, String travellersId);

    String cancelFlight(Long itineraryId);

    String confirmFlight(Long itineraryId, PaymentForm paymentForm);
}
