package com.flightsbooking.service.impl;

import com.flightsbooking.dao.CustomerRepository;
import com.flightsbooking.dao.FlightsRepository;
import com.flightsbooking.dao.ItineraryRepository;
import com.flightsbooking.dao.TravellerRepository;
import com.flightsbooking.dto.BankPayment;
import com.flightsbooking.dto.CardPayment;
import com.flightsbooking.dto.CustomerDto;
import com.flightsbooking.dto.FlightDto;
import com.flightsbooking.dto.FlightSegmentDto;
import com.flightsbooking.dto.ItineraryDto;
import com.flightsbooking.dto.ItinerarySegmentDto;
import com.flightsbooking.dto.PaymentDto;
import com.flightsbooking.dto.TravellerDto;
import com.flightsbooking.form.FlightForm;
import com.flightsbooking.form.FlightSearchCriteria;
import com.flightsbooking.form.FlightSegmentForm;
import com.flightsbooking.form.PaymentForm;
import com.flightsbooking.service.FlightService;
import com.flightsbooking.utils.DateUtils;
import com.flightsbooking.utils.ItineraryStatus;
import com.flightsbooking.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightsRepository flightsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TravellerRepository travellerRepository;
    @Autowired
    private ItineraryRepository itineraryRepository;

    @Override
    public List<FlightForm> searchFLights(FlightSearchCriteria flightSearchCriteria) {
        //TODO : make a service call to find the flights
        Date depDate = DateUtils.convertStringToDate(flightSearchCriteria.getDepartureDate(), StringConstants.DD_MM_YYYY);
        List<FlightDto> flightDtoList = flightsRepository.findFlightsByCriteria(
                flightSearchCriteria.getSource(), flightSearchCriteria.getDestination()
                ,DateUtils.beginOfDay(depDate), DateUtils.endOfDay(depDate));
        return convertDtoToForm(flightDtoList);
    }

    @Override
    public String bookFlight(String flightId, String customerId, String travellersId) {
        Long id = Long.parseLong(flightId);
        Long cusId = Long.parseLong(customerId);
        List<Long> travellerIds = new ArrayList<>();
        Optional<FlightDto> flightOpt= flightsRepository.findById(id);
        Optional<CustomerDto> customerDtoOptional = customerRepository.findById(cusId);
        String[] travellersArray = travellersId.split(",");
        for (String travellerId : travellersArray) {
            travellerIds.add(Long.parseLong(travellerId));
        }
        List<TravellerDto> travellerDtoList = travellerRepository.findTravellersByIds(travellerIds);
        //TODO : make a service call to book the flight

        ItineraryDto itineraryDto = prepareItinerary(flightOpt.get(),customerDtoOptional.get(), travellerDtoList);

        itineraryRepository.save(itineraryDto);

        return StringConstants.SUCCESS;
    }

    @Override
    public String cancelFlight(Long itineraryId) {
        Optional<ItineraryDto> itineraryDtoOptional = itineraryRepository.findById(itineraryId);
        if(itineraryDtoOptional.isPresent()) {
            //TODO : make a service call to cancel the flight
            ItineraryDto itineraryDto = itineraryDtoOptional.get();
            itineraryDto.setStatus(ItineraryStatus.CANCEL);
            itineraryRepository.save(itineraryDto);
            return StringConstants.SUCCESS;
        } else {
            return "No Flight available";
        }
    }

    @Override
    public String confirmFlight(Long itineraryId, PaymentForm paymentForm) {
        Optional<ItineraryDto> itineraryDtoOptional = itineraryRepository.findById(itineraryId);
        if(itineraryDtoOptional.isPresent()) {
            //TODO : make a service call to cancel the flight
            ItineraryDto itineraryDto = itineraryDtoOptional.get();
            itineraryDto.setStatus(ItineraryStatus.CONFIRM);
            PaymentDto paymentDto = null;
            if(!StringUtils.isEmpty(paymentForm.getAccountNumber())) {
                paymentDto = new BankPayment();
                ((BankPayment) paymentDto).setAccountNumber(paymentForm.getAccountNumber());
            } else if(!StringUtils.isEmpty(paymentForm.getCardNumber())) {
                paymentDto = new CardPayment();
                ((CardPayment) paymentDto).setCardNumber(paymentForm.getCardNumber());
            } else {
                return "Payment Details are empty";
            }
            paymentDto.setItineraryDto(itineraryDto);
            itineraryDto.setPaymentDto(paymentDto);
            itineraryRepository.save(itineraryDto);
            return StringConstants.SUCCESS;
        } else {
            return "No Flight available";
        }
    }

    private ItineraryDto prepareItinerary(FlightDto flightDto, CustomerDto customerDto, List<TravellerDto> travellerDtoList) {
        ItineraryDto itineraryDto = new ItineraryDto();
        itineraryDto.setSource(flightDto.getSource());
        itineraryDto.setDestination(flightDto.getDestination());
        itineraryDto.setDepartureDate(flightDto.getDepartureDate());
        itineraryDto.setArrivalDate(flightDto.getArrivalDate());
        itineraryDto.setStatus(ItineraryStatus.BOOK);
        itineraryDto.setBaseFare(flightDto.getBaseFare().multiply(BigDecimal.valueOf(travellerDtoList.size())));
        itineraryDto.setCustomerDto(customerDto);
        travellerDtoList.forEach(t->{
            List<ItineraryDto> itineraryDtoList = t.getItineraryDtoList();
            if(null == itineraryDtoList) {
                itineraryDtoList = new ArrayList<>();
            }
            itineraryDtoList.add(itineraryDto);
            t.setItineraryDtoList(itineraryDtoList);
        });
        itineraryDto.setTravellerDtoList(travellerDtoList);


        List<ItinerarySegmentDto> itinerarySegmentDtoList = new ArrayList<>();
        for (FlightSegmentDto flightSegmentDto : flightDto.getFlightSegments()) {
            itinerarySegmentDtoList.add(prepareItinerarySegment(flightSegmentDto));
        }
        itineraryDto.setItinerarySegmentDtoList(itinerarySegmentDtoList);




        return itineraryDto;

    }

    public List<FlightForm> convertDtoToForm(List<FlightDto> flightDtoList) {
        return flightDtoList.stream().map(this::convertToForm).collect(Collectors.toList());
    }

    /**
     * @param flightDto
     * @return
     */
    private FlightForm convertToForm(FlightDto flightDto) {
        FlightForm form = new FlightForm();
        form.setFlightId(flightDto.getId());
        form.setSource(flightDto.getSource());
        form.setDestination(flightDto.getDestination());
        form.setDepartureDate(DateUtils.convertDateToString(flightDto.getDepartureDate(), StringConstants.DD_MM_YYYY_HH_MM_SS));
        form.setArrivalDate(DateUtils.convertDateToString(flightDto.getArrivalDate(), StringConstants.DD_MM_YYYY_HH_MM_SS));
        List<FlightSegmentForm> flightSegmentFormList = flightDto.getFlightSegments().stream().map(this::prepareFlightSegmentForm).collect(Collectors.toList());
        form.setFlightSegmentFormList(flightSegmentFormList);
        return form;
    }

    private FlightSegmentForm prepareFlightSegmentForm(FlightSegmentDto flightSegmentDto) {
        FlightSegmentForm flightSegmentForm = new FlightSegmentForm();
        flightSegmentForm.setFlightNumber(flightSegmentDto.getFlightNumber());
        flightSegmentForm.setOperatingAirlines(flightSegmentDto.getOperatingAirlines());
        flightSegmentForm.setSource(flightSegmentDto.getSource());
        flightSegmentForm.setDestination(flightSegmentDto.getDestination());
        flightSegmentForm.setDepartureDate(DateUtils.convertDateToString(flightSegmentDto.getDepartureDate(), StringConstants.DD_MM_YYYY_HH_MM_SS));
        flightSegmentForm.setArrivalDate(DateUtils.convertDateToString(flightSegmentDto.getArrivalDate(), StringConstants.DD_MM_YYYY_HH_MM_SS));
        return flightSegmentForm;
    }

    private ItinerarySegmentDto prepareItinerarySegment(FlightSegmentDto flightSegmentDto) {
        ItinerarySegmentDto itinerarySegmentDto = new ItinerarySegmentDto();
        itinerarySegmentDto.setFlightNumber(flightSegmentDto.getFlightNumber());
        itinerarySegmentDto.setOperatingAirlines(flightSegmentDto.getOperatingAirlines());
        itinerarySegmentDto.setSource(flightSegmentDto.getSource());
        itinerarySegmentDto.setDestination(flightSegmentDto.getDestination());
        itinerarySegmentDto.setDepartureDate(flightSegmentDto.getDepartureDate());
        itinerarySegmentDto.setArrivalDate(flightSegmentDto.getArrivalDate());
        itinerarySegmentDto.setDepartureDate(flightSegmentDto.getDepartureDate());
        return itinerarySegmentDto;
    }
}
