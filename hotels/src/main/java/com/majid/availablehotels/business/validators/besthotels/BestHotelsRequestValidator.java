package com.majid.availablehotels.business.validators.besthotels;

import com.majid.availablehotels.business.entities.besthotels.BestHotelsRequest;
import com.majid.availablehotels.validator.Validator;

import java.util.Objects;

public class BestHotelsRequestValidator implements Validator<BestHotelsRequest> {

    @Override
    public void validate(BestHotelsRequest request) {
        if (Objects.isNull(request.getFromDate())||
                Objects.isNull(request.getToDate())||
                Objects.isNull(request.getCity())||
                request.getNumberOfAdults() < 1){
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
