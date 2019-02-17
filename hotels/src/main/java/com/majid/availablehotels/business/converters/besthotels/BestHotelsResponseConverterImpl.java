package com.majid.availablehotels.business.converters.besthotels;

import com.majid.availablehotels.business.entities.AvailableHotelsResponse;
import com.majid.availablehotels.business.entities.besthotels.BestHotelsResponse;
import com.majid.availablehotels.converter.Converter;

public class BestHotelsResponseConverterImpl implements Converter<BestHotelsResponse, AvailableHotelsResponse> {
    @Override
    public AvailableHotelsResponse convert(BestHotelsResponse bestHotelsResponse) {
        AvailableHotelsResponse availableHotelsResponse = new AvailableHotelsResponse();
        availableHotelsResponse.setProvider("BEST");
        availableHotelsResponse.setHotelName(bestHotelsResponse.getHotel());
        availableHotelsResponse.setFare(String.valueOf(bestHotelsResponse.getHotelFare()));
        availableHotelsResponse.setAmenities(bestHotelsResponse.getRoomAmenities());
        return availableHotelsResponse;
    }
}
