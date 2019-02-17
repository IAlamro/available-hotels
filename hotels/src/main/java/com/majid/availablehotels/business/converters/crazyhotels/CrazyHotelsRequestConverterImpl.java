package com.majid.availablehotels.business.converters.crazyhotels;

import com.majid.availablehotels.business.entities.AvailableHotelsRequest;
import com.majid.availablehotels.business.entities.crazyhotels.CrazyHotelsRequest;
import com.majid.availablehotels.converter.Converter;

import java.time.format.DateTimeFormatter;

public class CrazyHotelsRequestConverterImpl implements Converter<AvailableHotelsRequest, CrazyHotelsRequest> {
    @Override
    public CrazyHotelsRequest convert(AvailableHotelsRequest availableHotelsRequest) {
        CrazyHotelsRequest request = new CrazyHotelsRequest();
        request.setCity(availableHotelsRequest.getCity());
        request.setFrom(availableHotelsRequest.getFromDate().format(DateTimeFormatter.ISO_INSTANT));
        request.setTo(availableHotelsRequest.getToDate().format(DateTimeFormatter.ISO_INSTANT));
        request.setAdultsCount(availableHotelsRequest.getNumberOfAdults());
        return request;
    }
}
