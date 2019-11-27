package com.flightsbooking.controller;

import com.flightsbooking.form.FlightForm;
import com.flightsbooking.form.FlightSearchCriteria;
import com.flightsbooking.form.FlightSegmentForm;
import com.flightsbooking.form.PaymentForm;
import com.flightsbooking.service.FlightService;
import com.flightsbooking.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/flights")
public class FlightsController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/searchFlights", method = RequestMethod.POST)
    public List<FlightForm> searchFLights(@RequestBody FlightSearchCriteria flightSearchCriteria) {
        System.out.println(flightSearchCriteria);
        List<FlightForm> list = flightService.searchFLights(flightSearchCriteria);
        return list;
    }
    @RequestMapping(value = "/bookFlight", method = RequestMethod.POST)
    public String bookFlight(@RequestParam(name = "flightId") String flightId, @RequestParam String customerId,
                             @RequestParam(name = "id") String travellersId) {
        return flightService.bookFlight(flightId, customerId, travellersId);
    }

    @RequestMapping(value = "/cancelFlight", method = RequestMethod.POST)
    public String cancelFlight(@RequestParam(name = "itineraryId") Long itineraryId) {
        return flightService.cancelFlight(itineraryId);
    }

    @RequestMapping(value = "/confirmFlight", method = RequestMethod.POST)
    public String confirmFlight(@RequestBody PaymentForm paymentForm, @RequestParam Long itineraryId) {
        return flightService.confirmFlight(itineraryId, paymentForm);
    }

}
