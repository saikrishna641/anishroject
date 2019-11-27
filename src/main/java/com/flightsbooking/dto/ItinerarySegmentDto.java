package com.flightsbooking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="TEST_ITINERARY_SEGMENT")
public class ItinerarySegmentDto extends BaseDto {
    private String flightNumber;
    private String operatingAirlines;
    private String source;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private int legNumber;
    private ItineraryDto itineraryDto;

    @Column(name = "FLIGHT_NUMBER")
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    @Column(name = "OPERATING_AIRLINES")
    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public void setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
    }
    @Column(name = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    @Column(name = "DESTINATION")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    @Column(name = "DEPARTURE_DATE")
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    @Column(name = "ARRIVAL_DATE")
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    @Column(name = "LEG_NUMBER")
    public int getLegNumber() {
        return legNumber;
    }

    public void setLegNumber(int legNumber) {
        this.legNumber = legNumber;
    }
    @ManyToOne
    @JoinColumn(name="ITINERARY_ID")
    public ItineraryDto getItineraryDto() {
        return itineraryDto;
    }

    public void setItineraryDto(ItineraryDto itineraryDto) {
        this.itineraryDto = itineraryDto;
    }
}
