package com.definitionbuddy.helpers;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;
import static java.net.http.HttpClient.newBuilder;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HttpHelper {

    private final HttpClient client;

    private HttpHelper(HttpClient client){
        this.client = client;
    }

    public static HttpHelper newHelper(){
        return new HttpHelper(newBuilder().build());
    }

    public String sendGet(String uri){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, ofString());
        } catch (IOException e){
            throw new UncheckedIOException(format("Could not retrieve date from URI %s", uri), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Failed to finish HTTP GET Request");
        }
        return response.body();
    }
}
