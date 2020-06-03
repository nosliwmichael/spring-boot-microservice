package com.sbm.scraper.internalendpoint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.Feign;
import feign.RequestLine;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public interface GenericEndpoint {

    class GenericResponse {
        public String response;
    }

    @RequestLine("GET")
    Response getResponse();

    static GenericEndpoint connect(String url) {
        final Gson gson = new GsonBuilder().setLenient().create();
        final Decoder decoder = new GsonDecoder(gson);
        final Encoder encoder = new GsonEncoder(gson);
        return Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .target(GenericEndpoint.class, url);
    }

}
