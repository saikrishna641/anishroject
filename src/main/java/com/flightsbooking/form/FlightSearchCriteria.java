package com.flightsbooking.form;

public class FlightSearchCriteria {

    private String source;
    private String destination;
    private String tripType;
    private int noOfAdults;
    private int noOfChild;
    private int noOfInfants;
    private String cabinClass;
    private String departureDate;
    private String returnDate;


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

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoOfChild() {
        return noOfChild;
    }

    public void setNoOfChild(int noOfChild) {
        this.noOfChild = noOfChild;
    }

    public int getNoOfInfants() {
        return noOfInfants;
    }

    public void setNoOfInfants(int noOfInfants) {
        this.noOfInfants = noOfInfants;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "FlightSearchCriteria{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", tripType='" + tripType + '\'' +
                ", noOfAdults=" + noOfAdults +
                ", noOfChild=" + noOfChild +
                ", noOfInfants=" + noOfInfants +
                ", cabinClass='" + cabinClass + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
