package com.majid.availablehotels.business.entities.crazyhotels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CrazyHotelsResponse {
    private String hotelName;
    private String rate;
    private double price;
    private double discount;
    private String hotelFare;
    private String amenities;
}
