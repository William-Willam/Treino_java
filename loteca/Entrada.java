package loteca;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Entrada {
    private ArrayList<String> nomeContas = new ArrayList<>();
    private ArrayList<Double> valorContas = new ArrayList<>();
    private ArrayList<String> nomeJogos = new ArrayList<>();
    private ArrayList<Integer> qtdBilhetes = new ArrayList<>();
    private ArrayList<Double> valorBilhete = new ArrayList<>();
    private ArrayList<String> nomeClientesDeposito = new ArrayList<>();
    private ArrayList<Double> valorDepositos = new ArrayList<>();

    public void adicionarConta(String nome, double valor) {
        nomeContas.add(nome);
        valorContas.add(valor);
    }

    public void adicionarJogo(String nome, int qtd, double valorUnitario) {
        nomeJogos.add(nome);
        qtdBilhetes.add(qtd);
        valorBilhete.add(valorUnitario);
    }

    public void adicionarDeposito(String cliente, double valor) {
        nomeClientesDeposito.add(cliente);
        valorDepositos.add(valor);
    }

    public double calcularTotalEntradas() {
        double total = 0;
        for (double valor : valorContas) total += valor;
        for (int i = 0; i < qtdBilhetes.size(); i++)
            total += qtdBilhetes.get(i) * valorBilhete.get(i);
        for (double valor : valorDepositos) total += valor;
        return total;
    }

    public void mostrarHistorico() {
        System.out.println("=== HISTÓRICO DE ENTRADAS ===");
        for (int i = 0; i < nomeContas.size(); i++)
            System.out.printf("Conta: %s - R$ %.2f\n", nomeContas.get(i), valorContas.get(i));
        for (int i = 0; i < nomeJogos.size(); i++)
            System.out.printf("Jogo: %s - %d x R$ %.2f\n", nomeJogos.get(i), qtdBilhetes.get(i), valorBilhete.get(i));
        for (int i = 0; i < nomeClientesDeposito.size(); i++)
            System.out.printf("Depósito: %s - R$ %.2f\n", nomeClientesDeposito.get(i), valorDepositos.get(i));
        System.out.printf("TOTAL ENTRADAS: R$ %.2f\n", calcularTotalEntradas());
    }

    public void salvarEmArquivo(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("=== RELATÓRIO DE ENTRADAS ===\n\n");
            for (int i = 0; i < nomeContas.size(); i++)
                writer.write(String.format("Conta: %s - R$ %.2f\n", nomeContas.get(i), valorContas.get(i)));
            for (int i = 0; i < nomeJogos.size(); i++)
                writer.write(String.format("Jogo: %s - %d x R$ %.2f\n", nomeJogos.get(i), qtdBilhetes.get(i), valorBilhete.get(i)));
            for (int i = 0; i < nomeClientesDeposito.size(); i++)
                writer.write(String.format("Depósito: %s - R$ %.2f\n", nomeClientesDeposito.get(i), valorDepositos.get(i)));
            writer.write(String.format("\nTOTAL ENTRADAS: R$ %.2f\n", calcularTotalEntradas()));
        } catch (IOException e) {
            System.out.println("Erro ao salvar entradas: " + e.getMessage());
        }
    }
}