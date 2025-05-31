package loteca;

public class Pagamento {
    private double despesasLoja = 0;

    public void registrarDespesaLoja(double valor) {
        despesasLoja += valor;
    }

    public double calcularTotalPagamentos() {
        return despesasLoja;
    }

    public void mostrarDetalhes() {
        System.out.printf("Despesas da Loja: R$ %.2f\n", despesasLoja);
    }
}