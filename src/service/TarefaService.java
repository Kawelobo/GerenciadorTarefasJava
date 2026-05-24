package service;

import model.Tarefa;

import java.util.ArrayList;

public class TarefaService {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private int contadorId = 1;

    public void adicionarTarefa(String nome) {

        Tarefa tarefa = new Tarefa(contadorId, nome);
        tarefas.add(tarefa);

        contadorId++;

        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {

        if(tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("\n===== LISTA DE TAREFAS =====");

        for(Tarefa tarefa : tarefas) {
            System.out.println(
                    "ID: " + tarefa.getId() +
                    " | Nome: " + tarefa.getNome()
            );
        }
    }

    public void atualizarTarefa(int id, String novoNome) {

        for(Tarefa tarefa : tarefas) {

            if(tarefa.getId() == id) {

                tarefa.setNome(novoNome);

                System.out.println("Tarefa atualizada!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }

    public void removerTarefa(int id) {

        for(Tarefa tarefa : tarefas) {

            if(tarefa.getId() == id) {

                tarefas.remove(tarefa);

                System.out.println("Tarefa removida!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }
}
