package com.marechal.primeira;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private String turno;
    private Disciplina disciplina;
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(int id, String nome, String turno, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.disciplina = disciplina;
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTurno() {
        return turno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public int getNumeroAlunos() {
        return alunos.size();
    }
}

