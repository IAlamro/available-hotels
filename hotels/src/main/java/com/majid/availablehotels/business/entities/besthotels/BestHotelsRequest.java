package com.majid.availablehotels.business.entities.besthotels;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class BestHotelsRequest {

    private String city;
    private String fromDate;
    private String toDate;
    private int numberOfAdults;
}
