package com.majid.availablehotels.business.converters.besthotels;

import com.majid.availablehotels.business.entities.AvailableHotelsRequest;
import com.majid.availablehotels.business.entities.besthotels.BestHotelsRequest;
import com.majid.availablehotels.business.validators.besthotels.BestHotelsRequestValidator;
import com.majid.availablehotels.converter.Converter;
import com.majid.availablehotels.validator.Validate;
import com.sun.istack.internal.NotNull;

import java.time.format.DateTimeFormatter;

public class BestHotelsRequestConverterImpl implements Converter<AvailableHotelsRequest, BestHotelsRequest> {

    @Validate(BestHotelsRequestValidator.class)
    @Override
    public BestHotelsRequest convert(@NotNull AvailableHotelsRequest availableHotelsRequest) {
        BestHotelsRequest request = new BestHotelsRequest();
        request.setCity(availableHotelsRequest.getCity());
        request.setFromDate(availableHotelsRequest.getFromDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        request.setToDate(availableHotelsRequest.getToDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        request.setNumberOfAdults(availableHotelsRequest.getNumberOfAdults());
        return request;
    }
}
