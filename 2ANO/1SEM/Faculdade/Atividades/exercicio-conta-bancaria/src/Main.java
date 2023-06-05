import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaObj<Operacao> pilhaOperacoes = new PilhaObj<>(10);
        FilaObj<Operacao> filaOperacoes = new FilaObj<>(10);
        int contadorOperacoes = 0;

        ContaBancaria conta1 = new ContaBancaria(1, 1000.0);
        ContaBancaria conta2 = new ContaBancaria(2, 2000.0);

        while (true) {
            System.out.println("1- Debitar valor");
            System.out.println("2- Creditar (Depositar) valor");
            System.out.println("3- Desfazer operação");
            System.out.println("4- Agendar operação");
            System.out.println("5- Executar operações agendadas");
            System.out.println("6- Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o número da conta: ");
                    int numeroContaDebito = scanner.nextInt();
                    System.out.print("Digite o valor a ser debitado: ");
                    double valorDebito = scanner.nextDouble();
                    ContaBancaria contaDebito = null;
                    if (numeroContaDebito == conta1.getNumero()) {
                        contaDebito = conta1;
                    } else if (numeroContaDebito == conta2.getNumero()) {
                        contaDebito = conta2;
                    }
                    if (contaDebito == null) {
                        System.out.println("Conta bancária não encontrada.");
                        break;
                    }
                    boolean debitoRealizado = contaDebito.debitar(valorDebito);
                    if (debitoRealizado) {
                        Operacao operacaoDebito = new Operacao();
                        operacaoDebito.setObjConta(contaDebito);
                        operacaoDebito.setTipoOperacao("debito");
                        operacaoDebito.setValor(valorDebito);
                        pilhaOperacoes.push(operacaoDebito);
                        contadorOperacoes++;
                    }
                }
                case 2 -> {
                    System.out.print("Digite o número da conta: ");
                    int numeroContaCredito = scanner.nextInt();
                    System.out.print("Digite o valor a ser creditado: ");
                    double valorCredito = scanner.nextDouble();
                    ContaBancaria contaCredito = null;
                    if (numeroContaCredito == conta1.getNumero()) {
                        contaCredito = conta1;
                    } else if (numeroContaCredito == conta2.getNumero()) {
                        contaCredito = conta2;
                    }
                    if (contaCredito == null) {
                        System.out.println("Conta bancária não encontrada.");
                        break;
                    }
                    contaCredito.creditar(valorCredito);
                    Operacao operacaoCredito = new Operacao();
                    operacaoCredito.setObjConta(contaCredito);
                    operacaoCredito.setTipoOperacao("credito");
                    operacaoCredito.setValor(valorCredito);
                    pilhaOperacoes.push(operacaoCredito);
                    contadorOperacoes++;
                }
                case 3 -> {
                    System.out.print("Digite a quantidade de operações a serem desfeitas: ");
                    int quantidadeDesfazer = scanner.nextInt();
                    if (quantidadeDesfazer > contadorOperacoes) {
                        System.out.println("Quantidade inválida. Não há operações suficientes para desfazer.");
                        break;
                    }
                    for (int i = 0; i < quantidadeDesfazer; i++) {
                        Operacao operacaoDesfazer = pilhaOperacoes.pop();

                        if (operacaoDesfazer.getTipoOperacao().equals("debito")) {
                            operacaoDesfazer.getObjConta().creditar(operacaoDesfazer.getValor());
                        } else if (operacaoDesfazer.getTipoOperacao().equals("credito")) {
                            operacaoDesfazer.getObjConta().debitar(operacaoDesfazer.getValor());
                        }

                        contadorOperacoes--;
                    }
                }
                case 4 -> {
                    System.out.print("Digite o tipo de operação (debito ou credito): ");
                    String tipoOperacao = scanner.next();
                    System.out.print("Digite o número da conta: ");
                    int numeroContaAgendar = scanner.nextInt();
                    System.out.print("Digite o valor: ");
                    double valorOperacao = scanner.nextDouble();
                    ContaBancaria contaAgendar = null;
                    if (numeroContaAgendar == conta1.getNumero()) {
                        contaAgendar = conta1;
                    } else if (numeroContaAgendar == conta2.getNumero()) {
                        contaAgendar = conta2;
                    }
                    if (contaAgendar == null) {
                        System.out.println("Conta bancária não encontrada.");
                        break;
                    }
                    Operacao operacaoAgendada = new Operacao();
                    operacaoAgendada.setObjConta(contaAgendar);
                    operacaoAgendada.setTipoOperacao(tipoOperacao);
                    operacaoAgendada.setValor(valorOperacao);
                    try {
                        filaOperacoes.enqueue(operacaoAgendada);
                        System.out.println("Operação agendada com sucesso.");
                    } catch (IllegalStateException e) {
                        System.out.println("A fila de operações agendadas está cheia. Não é possível agendar mais operações.");
                    }
                }
                case 5 -> {
                    if (filaOperacoes.isEmpty()) {
                        System.out.println("Não há operações agendadas.");
                        break;
                    }
                    while (!filaOperacoes.isEmpty()) {
                        Operacao operacaoExecutar = filaOperacoes.dequeue();

                        if (operacaoExecutar.getTipoOperacao().equals("debito")) {
                            operacaoExecutar.getObjConta().debitar(operacaoExecutar.getValor());
                        } else if (operacaoExecutar.getTipoOperacao().equals("credito")) {
                            operacaoExecutar.getObjConta().creditar(operacaoExecutar.getValor());
                        }

                        System.out.println("Operação executada: " + operacaoExecutar);
                    }
                }
                case 6 -> {
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Digite uma opção válida.");
            }

            System.out.println();
        }
    }
}
