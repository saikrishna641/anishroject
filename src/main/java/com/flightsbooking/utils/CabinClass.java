package com.flightsbooking.utils;

public enum CabinClass {
    First("F"),
    Business("J"),
    Economy("Y");

    private String code;

    CabinClass(String cabinCode) {
        this.code = cabinCode;
    }
}
