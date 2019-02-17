package com.majid.availablehotels.business.entities.crazyhotels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CrazyHotelsRequest {

    private String city;
    private String from;
    private String to;
    private int adultsCount;
}
