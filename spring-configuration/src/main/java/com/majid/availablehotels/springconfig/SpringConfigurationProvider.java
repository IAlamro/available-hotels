package com.majid.availablehotels.springconfig;

import com.majid.availablehotels.RestClient;
import com.majid.availablehotels.RestClientImpl;
import com.majid.availablehotels.business.converters.besthotels.BestHotelsRequestConverterImpl;
import com.majid.availablehotels.business.converters.besthotels.BestHotelsResponseConverterImpl;
import com.majid.availablehotels.business.converters.crazyhotels.CrazyHotelsRequestConverterImpl;
import com.majid.availablehotels.business.converters.crazyhotels.CrazyResponseConverterImpl;
import com.majid.availablehotels.business.entities.AvailableHotelsRequest;
import com.majid.availablehotels.business.entities.AvailableHotelsResponse;
import com.majid.availablehotels.business.entities.HotelProvider;
import com.majid.availablehotels.business.entities.HotelsProviderImpl;
import com.majid.availablehotels.business.entities.besthotels.BestHotelsResponse;
import com.majid.availablehotels.business.entities.crazyhotels.CrazyHotelsRequest;
import com.majid.availablehotels.business.entities.crazyhotels.CrazyHotelsResponse;
import com.majid.availablehotels.converter.Converter;
import com.majid.availablehotels.service.rest.AvailableHotelsExecuterService;
import com.majid.availablehotels.validator.Validate;
import com.majid.availablehotels.validator.Validator;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

import static java.util.Arrays.asList;

@Configuration
@ComponentScan("com.majid.availablehotels.service.rest")
@PropertySource("classpath:uri_configuration.properties")
public class SpringConfigurationProvider {

//    @Value("${crazy.uri}")
//    private String crazyUri;
//    @Value("${best.uri}")
//    private String bestUri;

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertyPlaceholderConfigurer();
    }

    @Bean
    public AvailableHotelsExecuterService availableHotelsExecuterService(BestHotelsRequestConverterImpl bestHotelsRequestConverter) {
        return new AvailableHotelsExecuterService(asList(bestHotelProvider(bestHotelsRequestConverter), crazyHotelProvider()));
    }

    private HotelProvider bestHotelProvider(BestHotelsRequestConverterImpl bestHotelsRequestConverter) {
        RestClient<BestHotelsResponse> bestHotelsResponseRestClient = new RestClientImpl<>("", BestHotelsResponse.class);
        Converter<BestHotelsResponse, AvailableHotelsResponse> bestHotelsResponseConverter = new BestHotelsResponseConverterImpl();
        return new HotelsProviderImpl<>(bestHotelsRequestConverter, bestHotelsResponseConverter, bestHotelsResponseRestClient);
    }

    @Bean
    public BestHotelsRequestConverterImpl bestHotelsRequestConverter() {
        return new BestHotelsRequestConverterImpl();
    }

    private HotelProvider crazyHotelProvider() {
        RestClient<CrazyHotelsResponse> restClient = new RestClientImpl<>("", CrazyHotelsResponse.class);
        Converter<CrazyHotelsResponse, AvailableHotelsResponse> crazyResponseConverter = new CrazyResponseConverterImpl();
        Converter<AvailableHotelsRequest, CrazyHotelsRequest> crazyHotelsRequestConverter = new CrazyHotelsRequestConverterImpl();
        return new HotelsProviderImpl<>(crazyHotelsRequestConverter, crazyResponseConverter, restClient);
    }

    public static List<Method> getMethodsAnnotatedWith() throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections();
        final List<Method> methods = new LinkedList<>();
        Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(Validate.class);
        for (Method method: methodsAnnotatedWith){
            Class<? extends Validator>[] validatorClasses = method.getAnnotation(Validate.class).value();
            for (Class<? extends Validator> validatorClass : validatorClasses){
                Validator validator = validatorClass.newInstance();

            }
        }
        return methods;
    }
}
