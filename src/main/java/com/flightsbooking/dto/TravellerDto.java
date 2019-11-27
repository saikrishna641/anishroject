package com.flightsbooking.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="TEST_TRAVELLER")
public class TravellerDto extends BaseDto {

    private String firstName;
    private String middleName;
    private String lastName;
    private String passportNumber;
    private CustomerDto customerDto;
    private List<ItineraryDto> itineraryDtoList;

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "MIDDLE_NAME")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "PASSPORT_NUMBER")
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "TEST_TRAVELLER_ITINERARY",
            joinColumns = { @JoinColumn(name = "TRAVELLER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ITINERARY_ID") }
    )
    public List<ItineraryDto> getItineraryDtoList() {
        return itineraryDtoList;
    }

    public void setItineraryDtoList(List<ItineraryDto> itineraryDtoList) {
        this.itineraryDtoList = itineraryDtoList;
    }
}
