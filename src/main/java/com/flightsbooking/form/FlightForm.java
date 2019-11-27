package com.flightsbooking.form;

import java.sql.Timestamp;
import java.util.List;

public class FlightForm {
    private Long flightId;
    private String source;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private List<FlightSegmentForm> flightSegmentFormList;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public List<FlightSegmentForm> getFlightSegmentFormList() {
        return flightSegmentFormList;
    }

    public void setFlightSegmentFormList(List<FlightSegmentForm> flightSegmentFormList) {
        this.flightSegmentFormList = flightSegmentFormList;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
