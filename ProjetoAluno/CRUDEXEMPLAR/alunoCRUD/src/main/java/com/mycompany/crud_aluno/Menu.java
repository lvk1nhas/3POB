package com.mycompany.crud_aluno;

import com.mycompany.crud_aluno.Aluno;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Menu {
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private int opcao = 0;

    public void Processamento() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Digite a opção:");
            System.out.println("1- Incluir Aluno");
            System.out.println("2- Alterar Aluno");
            System.out.println("3- Excluir Aluno");
            System.out.println("4- Listar Alunos");
            System.out.println("5- Buscar Aluno");
            System.out.println("6- Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    IncluirAluno();
                    break;
                case 2:
                    AlterarAluno();
                    break;
                case 3:
                    ExcluirAluno();
                    break;
                case 4:
                    ListarAluno();
                    break;
                case 5:
                    BuscarAluno();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 6);
    }

    public Boolean ValidaNome(String nome) {
    Pattern pattern = Pattern.compile("^[A-Za-z\\s]+$");
    Matcher matcher = pattern.matcher(nome);
    boolean matchFound = matcher.matches();
    if (matchFound) {
        System.out.println("Nome válido.");
    }
    return matchFound;
}


    public Boolean ValidaCpf(String cpf) {
    Pattern pattern = Pattern.compile("^[0-9]{11}$");
    Matcher matcher = pattern.matcher(cpf);
    boolean matchFound = matcher.matches();
    if (matchFound) {
        System.out.println("CPF válido.");
    }
    return matchFound;
}

public Boolean ValidaMatricula(String matricula) {
   Pattern pattern = Pattern.compile("^[0-9]{5}$");
    Matcher matcher = pattern.matcher(matricula);
    boolean matchFound = matcher.matches();
    if (matchFound) {
        System.out.println("Matrícula válida.");
    }
    return matchFound;
}



    public boolean IncluirAluno() {
        String nome, cpf, matricula, endereco, cep, dtAux;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu primeiro nome: ");
        nome = sc.next();
        if (!ValidaNome(nome)) {
            System.out.println("Nome inválido. Tente novamente.");
            return false;
        }

        System.out.println("Digite seu CPF (so os numeros): ");
        cpf = sc.next();
        if (!ValidaCpf(cpf)) {
            System.out.println("CPF inválido. Tente novamente.");
            return false;
        }

        System.out.println("Digite sua matrícula: (5 numeros)");
        matricula = sc.next();
        if (!ValidaMatricula(matricula)) {
            System.out.println("Matricula inválida. Tente novamente.");
            return false;
        }

        System.out.println("Digite sua data de nascimento (dia/mes/ano): ");
        dtAux = sc.next();
        System.out.println("Digite seu Endereço: ");
        sc.nextLine(); // Limpa o buffer de entrada
        endereco = sc.nextLine(); // Lê a linha completa
        System.out.println("Valor do endereço: " + endereco);
        System.out.println("Digite seu CEP (só os números): ");
        cep = sc.next();

        Aluno aluno = new Aluno(nome, cpf, matricula, dtAux, endereco, cep);
        alunos.add(aluno);

        return true;
    }

    public void AlterarAluno() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite a matrícula do aluno que você deseja alterar: ");
    String matricula = sc.next();

    for (Aluno altAluno : alunos) {
        if (altAluno.getMatricula().equals(matricula)) {
            System.out.println("Aluno encontrado. Digite os novos dados:");

            System.out.println("Digite o novo endereço: ");
            String novoEndereco = sc.next();
            altAluno.setEndereco(novoEndereco);

            System.out.println("Digite o novo CEP: ");
            String novoCep = sc.next();
            altAluno.setCep(novoCep);

            System.out.println("Aluno atualizado com sucesso.");
            return;
        }
    }
    System.out.println("Aluno não encontrado.");
}

    public void ExcluirAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a matrícula do aluno que você deseja excluir: ");
        String matricula = sc.next();

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunos.remove(aluno);
                System.out.println("Aluno excluído com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void ListarAluno() {
    for (Aluno aluno : alunos) {
        aluno.Informacoes(); // Exibe as informações do aluno
        System.out.println(); // Adiciona uma linha em branco entre os alunos
    }
}


    public void BuscarAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a matrícula do aluno que você deseja buscar: ");
        String matricula = sc.next();

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println(aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }
}
