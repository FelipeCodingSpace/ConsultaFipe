package br.edu.uea;

import com.google.gson.*;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public String selecionarOpcao(String mensagem, JsonArray opcoes) {
        System.out.println(mensagem);

        IntStream.range(0, opcoes.size())
                .forEach(i -> {
                    JsonObject opcao = opcoes.get(i).getAsJsonObject();
                    System.out.println((i + 1) + ". " + opcao.get("nome").getAsString());
                });

        System.out.println("Digite o número da sua escolha ou 'sair' para encerrar o programa:");

        String entrada = scanner.nextLine();
        if (entrada.equalsIgnoreCase("sair")) {
            sairDoPrograma();
        }

        int escolha = Integer.parseInt(entrada);
        return opcoes.get(escolha - 1).getAsJsonObject().get("codigo").getAsString();
    }

    public String selecionarModelo(String mensagem, JsonObject opcoes) {
        JsonArray modelos = opcoes.getAsJsonArray("modelos");
        return selecionarOpcao(mensagem, modelos);
    }

    public void exibirDetalhesVeiculo(JsonObject detalhes) {
        System.out.println("Detalhes do veículo:");
        detalhes.entrySet().stream()
                .filter(entry -> !entry.getKey().equalsIgnoreCase("TipoVeiculo"))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().getAsString()));
    }

    public int lerTipoVeiculo() {
        System.out.println("Selecione o tipo de veículo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.println("3. Caminhão");
        System.out.println("Digite o número da sua escolha ou 'sair' para encerrar o programa:");

        String entrada = scanner.nextLine();
        if (entrada.equalsIgnoreCase("sair")) {
            sairDoPrograma();
        }

        return Integer.parseInt(entrada);
    }

    public String tipoVeiculoToString(int tipoVeiculo) {
        return switch (tipoVeiculo) {
            case 1 -> "carros";
            case 2 -> "motos";
            case 3 -> "caminhoes";
            default -> throw new IllegalArgumentException("Tipo de veículo inválido.");
        };
    }

    private void sairDoPrograma() {
        System.out.println("Aplicação encerrada pelo usuário.");
        System.exit(0);
    }
}
