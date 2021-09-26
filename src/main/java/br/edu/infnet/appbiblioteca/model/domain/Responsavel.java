package br.edu.infnet.appbiblioteca.model.domain;

public class Responsavel {
	
	private String nome;
	private String email;
	private int idade;
	
	
	public Responsavel(String nome, String email, int idade) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		sb.append(idade);

		return sb.toString();
	}
	
	
	
	

}
