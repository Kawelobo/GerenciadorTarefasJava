package app;

import model.Tarefa;
import service.TarefaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TarefaService service = new TarefaService();

        int opcao;

        do {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String nome = scanner.nextLine();

                    if(nome.isEmpty()) {
                        System.out.println("Nome inválido!");
                    } else {
                        service.adicionarTarefa(nome);
                    }
                    break;

                case 2:
                    service.listarTarefas();
                    break;

                case 3:
                    System.out.print("Digite o ID da tarefa: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    service.atualizarTarefa(idAtualizar, novoNome);
                    break;

                case 4:
                    System.out.print("Digite o ID da tarefa: ");
                    int idRemover = scanner.nextInt();

                    service.removerTarefa(idRemover);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        scanner.close();
    }
}
