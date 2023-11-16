package com.marechal.primeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Aluno> alunos = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private int opcao = 0;
    private Scanner sc = new Scanner(System.in);

    public void Processamento() {
        do {
            System.out.println("Escolha sua opção:");
            System.out.println("1- Incluir Aluno");
            System.out.println("2- Listar alunos incluídos");
            System.out.println("3- Criar Disciplina");
            System.out.println("4- Criar Turma");
            System.out.println("5- Listar Turmas");
            System.out.println("6- Adicionar Aluno à Turma");
            System.out.println("7- Sair");

            opcao = sc.nextInt();

            switch (opcao) {
            
                case 1:
                    IncluirAluno();
                    break;
                    
                case 2:
                    ListarAlunos();
                    break;
                    
                case 3:
                	criarDisciplina();
                    break;
                    
                case 4:
                	criarTurma();
                    break;
                    
                case 5:
                	 ListarTurmas();
                    break;
                    
                case 6:
                	AdicionarAlunoATurma();
                    break;
                    
                case 7:
                	System.exit(0);
                	break;
                	
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 6);

        // Fechar o Scanner ao sair do loop
        closeScanner();
    }

    public void IncluirAluno() {
        System.out.println("Digite o ID do aluno: ");
        int id = sc.nextInt();

        // Verifique se o ID já existe
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                System.out.println("ID já existe. Tente novamente.");
                return;
            }
        }

        System.out.println("Digite o nome do aluno: ");
        String nome = sc.next();

        System.out.println("Digite a matrícula do aluno: ");
        String matricula = sc.next();

        System.out.println("Digite o email do aluno: ");
        String email = sc.next();

        System.out.println("Digite o CPF do aluno: ");
        String cpf = sc.next();

        Aluno aluno = new Aluno(id, nome, matricula, email, cpf);
        alunos.add(aluno);
    }

    public void ListarAlunos() {
        System.out.println("Lista de Alunos:");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno incluído");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("ID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matrícula: " + aluno.getMatricula());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println();
            }
        }
    }

    public void AdicionarAlunoATurma() {
        // Listar os alunos disponíveis
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId() + ", Nome: " + aluno.getNome());
        }

        do {
            System.out.println("Digite o ID do aluno que deseja adicionar à turma: ");
            int idAluno = sc.nextInt();

            // Verificar se o ID do aluno existe
            Aluno alunoSelecionado = null;
            for (Aluno aluno : alunos) {
                if (aluno.getId() == idAluno) {
                    alunoSelecionado = aluno;
                    break;
                }
            }

            if (alunoSelecionado == null) {
                System.out.println("Aluno não encontrado. Tente novamente.");
                continue;
            }

            System.out.println("Digite o ID da turma à qual deseja adicionar o aluno: ");
            int idTurma = sc.nextInt();

            // Verificar se o ID da turma existe
            Turma turmaSelecionada = null;
            for (Turma turma : turmas) {
                if (turma.getId() == idTurma) {
                    turmaSelecionada = turma;
                    break;
                }
            }

            if (turmaSelecionada == null) {
                System.out.println("Turma não encontrada. Tente novamente.");
                continue;
            }

            turmaSelecionada.adicionarAluno(alunoSelecionado);

            System.out.println("Deseja adicionar outro aluno à turma? (1 - Sim, 2 - Não)");
            opcao = sc.nextInt();

            if (opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida. Tente novamente!");
            }

        } while (opcao == 1);
    }


    
    public void criarDisciplina() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID da disciplina: ");
        int idDisciplina = sc.nextInt();
        sc.nextLine();

        // Verifique se o ID da disciplina já existe
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == idDisciplina) {
                System.out.println("ID da disciplina já existe. Tente novamente.");
                return;
            }
        }

        System.out.println("Digite o nome da disciplina: ");
        String nomeDisciplina = sc.nextLine();

        System.out.println("Digite a sigla da disciplina: ");
        String siglaDisciplina = sc.nextLine();

        System.out.println("Digite a carga horária da disciplina: ");
        int cargaHorariaDisciplina = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Digite o ID do pré-requisito da disciplina (ou -1 se não houver): ");
        int idPreRequisito = sc.nextInt();
        sc.nextLine(); 

        Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina, siglaDisciplina, cargaHorariaDisciplina, idPreRequisito);
        disciplinas.add(disciplina);

        System.out.println("Disciplina criada com sucesso!");
    }
    
    public void criarTurma() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID da turma: ");
        int idTurma = sc.nextInt();
        sc.nextLine(); /

        // Verifique se o ID da turma já existe
        for (Turma turma : turmas) {
            if (turma.getId() == idTurma) {
                System.out.println("ID da turma já existe. Tente novamente.");
                return;
            }
        }

        System.out.println("Digite o nome da turma: ");
        String nomeTurma = sc.nextLine();

        System.out.println("Digite o turno da turma: ");
        String turnoTurma = sc.nextLine();

        System.out.println("Digite o ID da disciplina da turma: ");
        int idDisciplinaTurma = sc.nextInt();
        sc.nextLine(); 

        // Verificar se o ID da disciplina existe
        Disciplina disciplinaSelecionada = null;
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == idDisciplinaTurma) {
                disciplinaSelecionada = disciplina;
                break;
            }
        }

        if (disciplinaSelecionada == null) {
            System.out.println("Disciplina não encontrada. Tente novamente.");
            return;
        }

        // Criar a turma e adicioná-la à lista de turmas
        Turma turma = new Turma(idTurma, nomeTurma, turnoTurma, disciplinaSelecionada);
        turmas.add(turma);

        System.out.println("Turma criada com sucesso!");
    }



    public void ListarTurmas() {
        System.out.println("Lista de Turmas:");
        for (Turma turma : turmas) {
            System.out.println("ID: " + turma.getId());
            System.out.println("Nome: " + turma.getNome());
            System.out.println("Turno: " + turma.getTurno());

            List<Aluno> alunosTurma = turma.getAlunos();
            System.out.println("Número de Alunos na Turma: " + alunosTurma.size());
            
            System.out.println("Alunos na Turma:");
            for (Aluno aluno : alunosTurma) {
                System.out.println("Nome: " + aluno.getNome());
                // Adicione mais informações do aluno, se necessário
            }

            System.out.println();
        }
    }


    private void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}
