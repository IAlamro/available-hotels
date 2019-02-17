package com.majid.availablehotels.service.rest;

import com.majid.availablehotels.business.entities.AvailableHotelsRequest;
import com.majid.availablehotels.business.entities.AvailableHotelsResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/hotels")
public class AvailableHotelsController {

    @Inject
    private AvailableHotelsExecuterService availableHotelsExecuterService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<AvailableHotelsResponse> getAvailableHotelsResponses(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate, @QueryParam("city") String city, @QueryParam("numberOfAdults") int numberOfAdults) {
        LocalDate startingDate = LocalDate.parse(fromDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endingDate = LocalDate.parse(toDate, DateTimeFormatter.ISO_LOCAL_DATE);
        AvailableHotelsRequest request = AvailableHotelsRequest.builder().fromDate(startingDate).toDate(endingDate).city(city).numberOfAdults(numberOfAdults).build();
        return availableHotelsExecuterService.execute(request);
    }
}
