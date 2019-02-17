package com.majid.availablehotels.business.entities.besthotels;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class BestHotelsResponse {

    private String hotel;
    private double hotelRate;
    private double hotelFare;
    private String roomAmenities;
}
