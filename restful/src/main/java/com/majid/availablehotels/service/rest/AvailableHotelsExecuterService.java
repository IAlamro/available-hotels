package com.majid.availablehotels.service.rest;

import com.majid.availablehotels.business.entities.AvailableHotelsRequest;
import com.majid.availablehotels.business.entities.AvailableHotelsResponse;
import com.majid.availablehotels.business.entities.HotelProvider;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AvailableHotelsExecuterService {

    private final List<HotelProvider> hotelProviders;

    public List<AvailableHotelsResponse> execute(AvailableHotelsRequest request) {
        List<AvailableHotelsResponse> responses = new ArrayList<>();
        for (HotelProvider hotelProvider : hotelProviders) {
            AvailableHotelsResponse availableHotelsResponse = hotelProvider.callService(request);
            responses.add(availableHotelsResponse);
        }
        return responses;
    }
}
