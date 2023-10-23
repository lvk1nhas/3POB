package com.mycompany.crud_aluno;

public class Aluno {
	private String nome;
	private String cpf;
	private String matricula;
	private String dtNasc;
	private String endereco;
	private String cep;
	
	public Aluno(String nome, String cpf, String matricula, String dtNasc, String endereco, String cep) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.dtNasc = dtNasc;
		this.endereco = endereco;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public void Informacoes() {
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Matrícula: " + matricula);
    System.out.println("Data de Nascimento: " + dtNasc);
    System.out.println("Endereço: " + endereco);
    System.out.println("CEP: " + cep);
}

}
