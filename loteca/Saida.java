package loteca;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Saida {
    private ArrayList<String> nomePremiacoes = new ArrayList<>();
    private ArrayList<Double> valorPremiacoes = new ArrayList<>();
    private ArrayList<String> nomeComissoes = new ArrayList<>();
    private ArrayList<Double> valorComissoes = new ArrayList<>();
    private ArrayList<String> nomeClientesSaques = new ArrayList<>();
    private ArrayList<Double> valorSaques = new ArrayList<>();

    public void registrarPremiacao(String nome, double valor) {
        nomePremiacoes.add(nome);
        valorPremiacoes.add(valor);
    }

    public void registrarComissao(String tipo, double valor) {
        nomeComissoes.add(tipo);
        valorComissoes.add(valor);
    }

    public void registrarSaque(String cliente, double valor) {
        nomeClientesSaques.add(cliente);
        valorSaques.add(valor);
    }

    public double calcularTotalSaidas() {
        double total = 0;
        for (double v : valorPremiacoes) total += v;
        for (double v : valorComissoes) total += v;
        for (double v : valorSaques) total += v;
        return total;
    }

    public void mostrarHistorico() {
        System.out.println("=== HISTÓRICO DE SAÍDAS ===");
        for (int i = 0; i < nomePremiacoes.size(); i++)
            System.out.printf("Premiação: %s - R$ %.2f\n", nomePremiacoes.get(i), valorPremiacoes.get(i));
        for (int i = 0; i < nomeComissoes.size(); i++)
            System.out.printf("Comissão: %s - R$ %.2f\n", nomeComissoes.get(i), valorComissoes.get(i));
        for (int i = 0; i < nomeClientesSaques.size(); i++)
            System.out.printf("Saque: %s - R$ %.2f\n", nomeClientesSaques.get(i), valorSaques.get(i));
        System.out.printf("TOTAL SAÍDAS: R$ %.2f\n", calcularTotalSaidas());
    }

    public void salvarEmArquivo(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("=== RELATÓRIO DE SAÍDAS ===\n\n");
            for (int i = 0; i < nomePremiacoes.size(); i++)
                writer.write(String.format("Premiação: %s - R$ %.2f\n", nomePremiacoes.get(i), valorPremiacoes.get(i)));
            for (int i = 0; i < nomeComissoes.size(); i++)
                writer.write(String.format("Comissão: %s - R$ %.2f\n", nomeComissoes.get(i), valorComissoes.get(i)));
            for (int i = 0; i < nomeClientesSaques.size(); i++)
                writer.write(String.format("Saque: %s - R$ %.2f\n", nomeClientesSaques.get(i), valorSaques.get(i)));
            writer.write(String.format("\nTOTAL SAÍDAS: R$ %.2f\n", calcularTotalSaidas()));
        } catch (IOException e) {
            System.out.println("Erro ao salvar saídas: " + e.getMessage());
        }
    }
}