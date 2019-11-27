package com.flightsbooking.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.nio.file.Paths;
@Entity
@DiscriminatorValue("CARD")
public class CardPayment extends PaymentDto {

    private String cardNumber;

    @Column(name = "CARD_NUMBER")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
