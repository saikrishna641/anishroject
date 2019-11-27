package com.flightsbooking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TEST_FLIGHTS")
public class FlightDto extends BaseDto {


    private String source;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private BigDecimal baseFare;
    private List<FlightSegmentDto> flightSegments;

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

    @Column(name = "BASE_FARE")
    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }
    @OneToMany(mappedBy="flightDto")
    public List<FlightSegmentDto> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<FlightSegmentDto> flightSegments) {
        this.flightSegments = flightSegments;
    }
}
