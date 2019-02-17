package com.majid.availablehotels.springconfig;

import com.majid.availablehotels.service.rest.AvailableHotelsController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

@ApplicationPath("/api")
public class RestConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(asList(AvailableHotelsController.class));
    }
}
