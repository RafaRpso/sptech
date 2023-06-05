import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static Repositorio repositorio;
    private static Scanner scanner;
    private static DecimalFormat decimalFormat;

    public static void main(String[] args) {
        repositorio = new Repositorio();
        scanner = new Scanner(System.in);
        decimalFormat = new DecimalFormat("0.00");

        exibirMenu();
    }

    private static void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Salvar Petshop");
            System.out.println("2. Deletar Petshop pelo ID");
            System.out.println("3. Aumentar valor do Petshop pelo ID");
            System.out.println("4. Diminuir valor do Petshop pelo ID");
            System.out.println("5. Desfazer operações");
            System.out.println("6. Agendar deletar Petshop pelo ID");
            System.out.println("7. Executar operação agendada");
            System.out.println("8. Salvar Petshop após ID");
            System.out.println("9. Exibir relatório");
            System.out.println("0. Sair");

            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    salvarPetshop();
                    break;
                case 2:
                    deletarPetshop();
                    break;
                case 3:
                    aumentarValor();
                    break;
                case 4:
                    diminuirValor();
                    break;
                case 5:
                    desfazer();
                    break;
                case 6:
                    agendarDeletar();
                    break;
                case 7:
                    executarAgendado();
                    break;
                case 8:
                    salvarAposID();
                    break;
                case 9:
                    exibeRelatorio();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void salvarPetshop() {
        System.out.println("Digite os dados do Petshop:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Avaliação: ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();

        Petshop petshop = new Petshop(id, valor, nome, endereco, avaliacao, capacidade);
        repositorio.salvar(petshop);

        System.out.println("Petshop salvo com sucesso!");
    }

    private static void deletarPetshop() {
        System.out.print("Digite o ID do Petshop a ser deletado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        repositorio.deletarPeloId(id);

        System.out.println("Petshop deletado com sucesso!");
    }

    private static void aumentarValor() {
        System.out.print("Digite o ID do Petshop: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o valor de aumento: ");
        double valorDeAumento = scanner.nextDouble();

        repositorio.aumentarValorPeloId(id, valorDeAumento);

        System.out.println("Valor do Petshop aumentado com sucesso!");
    }

    private static void diminuirValor() {
        System.out.print("Digite o ID do Petshop: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o valor de diminuição: ");
        double valorDeDiminuicao = scanner.nextDouble();

        repositorio.diminuirValorPeloId(id, valorDeDiminuicao);

        System.out.println("Valor do Petshop diminuído com sucesso!");
    }

    private static void agendarDeletar() {
        System.out.print("Digite o ID do Petshop a ser agendado para deletar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        repositorio.agendarDeletarPeloId(id);

        System.out.println("Petshop agendado para deletar com sucesso!");
    }

    private static void executarAgendado() {
        repositorio.executarAgendado();

        System.out.println("Operação agendada executada com sucesso!");
    }

    private static void salvarAposID() {
        System.out.print("Digite o ID após o qual o Petshop será salvo: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite os dados do Petshop:");
        System.out.print("ID: ");
        int novoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Avaliação: ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();

        Petshop petshop = new Petshop(novoId, valor, nome, endereco, avaliacao, capacidade);
        repositorio.salvarAposId(petshop, id);

        System.out.println("Petshop salvo após o ID com sucesso!");
    }

    private static void exibeRelatorio() {
        System.out.println("Nome\tId\tValor\tEndereço\tAvaliação\tCapacidade");

        for (Petshop petshop : repositorio.getPetshops()) {
            System.out.print(petshop.getNome() + "\t");
            System.out.print(petshop.getId() + "\t");
            System.out.print(petshop.getValor() + "\t");
            System.out.print(petshop.getEndereco() + "\t");
            System.out.print(petshop.getAvaliacao() + "\t\t");
            System.out.print(petshop.getCapacidade() + "\t\t");
        }
    }

    private static void desfazer() {
        if (repositorio.desfazer()) {
            System.out.println("Operação desfeita com sucesso!");
        } else {
            System.out.println("Não há operação para desfazer.");
        }
    }

}
