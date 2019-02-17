package com.majid.availablehotels.business.entities;

import com.majid.availablehotels.RestClient;
import com.majid.availablehotels.converter.Converter;
import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import static com.majid.availablehotels.RestClientImpl.QueryParameter;

@AllArgsConstructor
public class HotelsProviderImpl<REQ, RES> implements HotelProvider {
    private final Converter<AvailableHotelsRequest, REQ> requestConverter;
    private final Converter<RES, AvailableHotelsResponse> responseConverter;
    private final RestClient<RES> restClient;

    public AvailableHotelsResponse callService(AvailableHotelsRequest request) {
        try {
            REQ req = requestConverter.convert(request);
            List<QueryParameter> queryParameters = getQueryParameters(req);
            RES response = restClient.sendRequest(queryParameters.toArray(new QueryParameter[0]));
            return responseConverter.convert(response);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private List<QueryParameter> getQueryParameters(REQ req) throws IllegalAccessException {
        List<QueryParameter> queryParameters = new LinkedList<QueryParameter>();
        Field[] declaredFields = req.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            QueryParameter queryParameter = new QueryParameter();
            queryParameter.setName(field.getName());
            queryParameter.setValues(field.get(req).toString());
            field.setAccessible(accessible);
            queryParameters.add(queryParameter);
        }
        return queryParameters;
    }
}
