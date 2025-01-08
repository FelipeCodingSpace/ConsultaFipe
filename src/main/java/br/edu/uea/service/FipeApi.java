package br.edu.uea.service;

import com.google.gson.*;
import java.io.IOException;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class FipeApi{
    private final HttpClient client;

    public FipeApi() {
        this.client = HttpClient.newHttpClient();
    }

    public JsonArray getJsonArray(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(java.net.URI.create(url)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return JsonParser.parseString(response.body()).getAsJsonArray();
        } else {
            throw new RuntimeException("Erro ao acessar a API: " + response.statusCode());
        }
    }

    public JsonObject getJsonObject(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(java.net.URI.create(url)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return JsonParser.parseString(response.body()).getAsJsonObject();
        } else {
            throw new RuntimeException("Erro ao acessar a API: " + response.statusCode());
        }
    }
}
