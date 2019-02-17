package com.majid.availablehotels.business.converters.crazyhotels;

import com.majid.availablehotels.business.entities.AvailableHotelsResponse;
import com.majid.availablehotels.business.entities.crazyhotels.CrazyHotelsResponse;
import com.majid.availablehotels.converter.Converter;

public class CrazyResponseConverterImpl implements Converter<CrazyHotelsResponse, AvailableHotelsResponse> {
    @Override
    public AvailableHotelsResponse convert(CrazyHotelsResponse crazyHotelsResponse) {
        AvailableHotelsResponse response = new AvailableHotelsResponse();
        response.setAmenities(crazyHotelsResponse.getAmenities());
        response.setFare(crazyHotelsResponse.getHotelFare());
        response.setHotelName(crazyHotelsResponse.getHotelName());
        response.setProvider("CRAZY");
        return response;
    }
}
