package com.majid.availablehotels;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClientImpl<R> implements RestClient<R> {

    private final Client client = ClientBuilder.newClient();
    private final String restUri;
    private final Class<R> clazz;

    public RestClientImpl(String restUri, Class<R> clazz) {
        this.restUri = restUri;
        this.clazz = clazz;
    }

    public R sendRequest(QueryParameter... queryParameters) {
        WebTarget target = client.target(restUri);
        for (QueryParameter queryParameter : queryParameters) {
            target.queryParam(queryParameter.getName(), queryParameter.getValues());
        }
        return target
                .request(MediaType.APPLICATION_JSON)
                .get(this.clazz);
    }
}