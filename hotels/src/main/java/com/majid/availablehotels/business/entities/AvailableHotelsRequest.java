package com.majid.availablehotels.business.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailableHotelsRequest {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String city;
    private int numberOfAdults;
}
