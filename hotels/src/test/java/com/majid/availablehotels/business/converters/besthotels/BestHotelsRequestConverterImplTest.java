package com.majid.availablehotels.business.converters.besthotels;

import com.majid.availablehotels.business.entities.AvailableHotelsRequest;
import com.majid.availablehotels.business.entities.besthotels.BestHotelsRequest;
import com.majid.availablehotels.converter.Converter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BestHotelsRequestConverterImplTest {

    private Converter<AvailableHotelsRequest, BestHotelsRequest> converter;

    @Before
    public void setup(){
        this.converter = new BestHotelsRequestConverterImpl();
    }

    @Test(expected = NullPointerException.class)
    public void givenNullRequest_thenAnExceptionShouldBeThrown(){
        converter.convert(null);
    }


}