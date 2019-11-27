package com.flightsbooking.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="TEST_PAYMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PAYMENT_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class PaymentDto extends BaseDto {

    private ItineraryDto itineraryDto;

    @ManyToOne
    @JoinColumn(name = "ITINERARY_ID", unique = true)
    public ItineraryDto getItineraryDto() {
        return itineraryDto;
    }

    public void setItineraryDto(ItineraryDto itineraryDto) {
        this.itineraryDto = itineraryDto;
    }
}
