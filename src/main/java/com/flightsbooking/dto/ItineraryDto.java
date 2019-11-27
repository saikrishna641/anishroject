package com.flightsbooking.dto;

import com.flightsbooking.utils.ItineraryStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="TEST_ITINERARY")
public class ItineraryDto extends BaseDto {

    private String source;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private ItineraryStatus status;
    private BigDecimal baseFare;
    private CustomerDto customerDto;
    private List<ItinerarySegmentDto> itinerarySegmentDtoList;
    private List<TravellerDto> travellerDtoList;
    private PaymentDto paymentDto;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public ItineraryStatus getStatus() {
        return status;
    }

    public void setStatus(ItineraryStatus status) {
        this.status = status;
    }
    @Column(name = "BASE_FARE")
    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    @OneToMany(mappedBy="itineraryDto", cascade = CascadeType.ALL)
    public List<ItinerarySegmentDto> getItinerarySegmentDtoList() {
        return itinerarySegmentDtoList;
    }

    public void setItinerarySegmentDtoList(List<ItinerarySegmentDto> itinerarySegmentDtoList) {
        this.itinerarySegmentDtoList = itinerarySegmentDtoList;
    }
    @ManyToMany(mappedBy = "itineraryDtoList", cascade = CascadeType.ALL)
    public List<TravellerDto> getTravellerDtoList() {
        return travellerDtoList;
    }

    public void setTravellerDtoList(List<TravellerDto> travellerDtoList) {
        this.travellerDtoList = travellerDtoList;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "itineraryDto", cascade = CascadeType.ALL)
    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }
}
