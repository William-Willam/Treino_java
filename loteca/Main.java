package loteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        Caixa caixa = new Caixa();

        System.out.println("===== CASA DA SORTE LTDA =====");
        System.out.println("== SISTEMA DE CONTROLE FINANCEIRO ==");

        // Autenticação
        boolean autenticado = false;
        while (!autenticado) {
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (usuario.autenticar(login, senha)) {
                System.out.println("Acesso permitido!");
                autenticado = true;
            } else {
                System.out.println("Credenciais inválidas. Tente novamente.");
            }
        }

        // Menu
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Registrar Entrada");
            System.out.println("2 - Registrar Saída");
            System.out.println("3 - Registrar Pagamento");
            System.out.println("4 - Ver Resumo Financeiro");
            System.out.println("5 - Ver Histórico de Transações");
            System.out.println("6 - Salvar Relatórios em Arquivos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Conta: ");
                    String nomeConta = scanner.nextLine();
                    System.out.print("Valor da Conta: ");
                    double valorConta = scanner.nextDouble();
                    caixa.getEntrada().adicionarConta(nomeConta, valorConta);
                    break;
                case 2:
                    System.out.print("Nome da Premiação: ");
                    String premio = scanner.nextLine();
                    System.out.print("Valor da Premiação: ");
                    double valorPremio = scanner.nextDouble();
                    caixa.getSaida().registrarPremiacao(premio, valorPremio);
                    break;
                case 3:
                    System.out.print("Valor da Despesa da Loja: ");
                    double despesa = scanner.nextDouble();
                    caixa.getPagamento().registrarDespesaLoja(despesa);
                    break;
                case 4:
                    caixa.mostrarResumo();
                    break;
                case 5:
                    System.out.println("\n--- HISTÓRICO COMPLETO ---");
                    caixa.getEntrada().mostrarHistorico();
                    caixa.getSaida().mostrarHistorico();
                    break;
                case 6:
                    caixa.getEntrada().salvarEmArquivo("relatorio_entradas.txt");
                    caixa.getSaida().salvarEmArquivo("relatorio_saidas.txt");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}