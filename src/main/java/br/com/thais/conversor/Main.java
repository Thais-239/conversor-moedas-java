package br.com.thais.conversor;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.DecimalFormat;


public class Main {

    private static final String API_KEY = System.getenv("API_KEY");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 1;

        if (API_KEY == null || API_KEY.isBlank()) {
            System.out.println("Erro: variável de ambiente API_KEY não configurada.");
            return;
        }

        while (opcao != 0) {

            System.out.println("""
            === Conversor de Moedas ===
            1 - Dólar → Real;
            2 - Real → Dólar;
            3 - Libra Turca → Real;
            4 - Real → Libra Turca;
            5 - Franco Suíço → Real;
            6 - Real → Franco Suíço;
            0 - Sair
            """);

            System.out.println("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    converter("USD", "BRL", "Dólar", "Real", scanner);
                    break;

                case 2:
                    converter("BRL", "USD", "Real", "Dólar", scanner);
                    break;

                case 3:
                    converter("TRY", "BRL", "Libra Turca", "Real", scanner);
                    break;

                case 4:
                    converter("BRL", "TRY", "Real", "Libra Turca", scanner);
                    break;

                case 5:
                    converter("CHF", "BRL", "Franco Suíço", "Real", scanner);
                    break;

                case 6:
                    converter("BRL", "CHF", "Real", "Franco Suíço", scanner);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }


            System.out.println();
        }

        scanner.close();
    }

    // Método responsável por pedir o valor ao usuário

    public static void converter(
            String moedaOrigem,
            String moedaDestino,
            String nomeOrigem,
            String nomeDestino,
            Scanner scanner) {

        System.out.println("Você escolheu: " + nomeOrigem + " para " + nomeDestino);
        System.out.println("Digite o valor em " + nomeOrigem + ": ");

        double valor = lerValor(scanner);
        chamarApi(moedaOrigem, moedaDestino, valor);

    }
    // Lê o valor aceitando vírgula ou ponto
    public static double lerValor(Scanner scanner) {
        String entrada = scanner.next();
        entrada = entrada.replace(",", ".");
        return Double.parseDouble(entrada);
    }
    // Chamada da API com resultado

    public static void chamarApi(String moedaOrigem, String moedaDestino, double valor) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/"
                    + API_KEY
                    + "/pair/"
                    + moedaOrigem
                    + "/"
                    + moedaDestino
                    + "/"
                    + valor;


            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser
                    .parseString(response.body())
                    .getAsJsonObject();

            String status = json.get("result").getAsString();

            if (!status.equals("success")) {
                System.out.println("Erro na API: " + status);
                return;
            }

            double resultado = json.get("conversion_result").getAsDouble();

            DecimalFormat df = new DecimalFormat("#,##0.00");

            System.out.println(
                    df.format(valor) + " " + moedaOrigem +
                            " = " +
                            df.format(resultado) + " " + moedaDestino
            );


        } catch (Exception e) {
            System.out.println("Erro ao realizar a conversão. Verifique sua conexão ou os dados informados.");

        }
    }
}
