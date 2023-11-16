package com.marechal.primeira;

public class Disciplina {
    private int id;
    private String nomeDisciplina;
    private String sigla;
    private int cargaHoraria;
    private int idPreRequisito;

    public Disciplina(int id, String nomeDisciplina, String sigla, int cargaHoraria, int idPreRequisito) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
        this.sigla = sigla;
        this.cargaHoraria = cargaHoraria;
        this.idPreRequisito = idPreRequisito;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getSigla() {
        return sigla;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getIdPreRequisito() {
        return idPreRequisito;
    }
}
