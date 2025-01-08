package br.edu.uea.service;

import com.google.gson.*;
import java.io.IOException;

public class FipeService {
    private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private final FipeApi apiClient;

    public FipeService(FipeApi apiClient) {
        this.apiClient = apiClient;
    }

    public JsonArray getMarcas(String tipoVeiculo) throws IOException, InterruptedException {
        String url = BASE_URL + tipoVeiculo + "/marcas";
        return apiClient.getJsonArray(url);
    }

    public JsonObject getModelos(String tipoVeiculo, String codigoMarca) throws IOException, InterruptedException {
        String url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos";
        return apiClient.getJsonObject(url);
    }

    public JsonArray getAnos(String tipoVeiculo, String codigoMarca, String codigoModelo) throws IOException, InterruptedException {
        String url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        return apiClient.getJsonArray(url);
    }

    public JsonObject getValor(String tipoVeiculo, String codigoMarca, String codigoModelo, String codigoAno) throws IOException, InterruptedException {
        String url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno;
        return apiClient.getJsonObject(url);
    }
}
