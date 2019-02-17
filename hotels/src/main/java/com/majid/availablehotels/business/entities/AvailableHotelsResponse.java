package com.majid.availablehotels.business.entities;

import lombok.Data;

@Data
public class AvailableHotelsResponse {
    private String provider;
    private String hotelName;
    private String fare;
    private String amenities;
}
