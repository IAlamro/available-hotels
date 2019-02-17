package com.majid.availablehotels.business.entities;

public interface HotelProvider {

    AvailableHotelsResponse callService(AvailableHotelsRequest request);
}
