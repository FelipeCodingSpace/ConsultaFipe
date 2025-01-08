package br.edu.uea;

import com.google.gson.*;
import br.edu.uea.service.FipeService;
import br.edu.uea.service.FipeApi;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                FipeApi apiClient = new FipeApi();
                FipeService fipeService = new FipeService(apiClient);
                Menu console = new Menu();

                int tipoVeiculo = console.lerTipoVeiculo();
                String tipo = console.tipoVeiculoToString(tipoVeiculo);

                JsonArray marcas = fipeService.getMarcas(tipo);
                String codigoMarca = console.selecionarOpcao("Selecione uma marca:", marcas);

                JsonObject modelos = fipeService.getModelos(tipo, codigoMarca);
                String codigoModelo = console.selecionarModelo("Selecione um modelo:", modelos);

                JsonArray anos = fipeService.getAnos(tipo, codigoMarca, codigoModelo);
                String codigoAno = console.selecionarOpcao("Selecione o ano:", anos);

                JsonObject valor = fipeService.getValor(tipo, codigoMarca, codigoModelo, codigoAno);
                console.exibirDetalhesVeiculo(valor);

            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
