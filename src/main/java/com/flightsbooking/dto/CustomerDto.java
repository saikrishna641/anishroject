package com.flightsbooking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TEST_CUSTOMER")
public class CustomerDto extends BaseDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private List<TravellerDto> travellerDtoList;
    private List<ItineraryDto> itineraryDtoList;

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "DATE_OF_BIRTH")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @OneToMany(mappedBy="customerDto")
    public List<TravellerDto> getTravellerDtoList() {
        return travellerDtoList;
    }

    public void setTravellerDtoList(List<TravellerDto> travellerDtoList) {
        this.travellerDtoList = travellerDtoList;
    }
    @OneToMany(mappedBy="customerDto")
    public List<ItineraryDto> getItineraryDtoList() {
        return itineraryDtoList;
    }

    public void setItineraryDtoList(List<ItineraryDto> itineraryDtoList) {
        this.itineraryDtoList = itineraryDtoList;
    }
}
