package com.marechal.primeira;

public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    private String email;
    private String cpf;

    public Aluno(int id, String nome, String matricula, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.cpf = cpf;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
