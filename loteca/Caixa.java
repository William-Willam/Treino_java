package loteca;

public class Caixa {
    private Entrada entrada = new Entrada();
    private Saida saida = new Saida();
    private Pagamento pagamento = new Pagamento();

    public Entrada getEntrada() {
        return entrada;
    }

    public Saida getSaida() {
        return saida;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public double calcularSaldoFinal() {
        return entrada.calcularTotalEntradas() - saida.calcularTotalSaidas() - pagamento.calcularTotalPagamentos();
    }

    public void mostrarResumo() {
        System.out.println("===== RESUMO FINANCEIRO =====");
        entrada.mostrarHistorico();
        saida.mostrarHistorico();
        pagamento.mostrarDetalhes();
        System.out.printf("SALDO FINAL: R$ %.2f\n", calcularSaldoFinal());
        System.out.println("==============================");
    }
}