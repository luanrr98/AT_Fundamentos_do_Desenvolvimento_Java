package br.edu.infnet.appbiblioteca.model.domain;

public abstract class Midia {
	
	private int id;
	private String nome;
	private String genero;
	private boolean baseadoOutraMidia;
	private double nota;
	
	
	
	public Midia(int id, String nome, String genero, boolean baseadoOutraMidia, double nota) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.baseadoOutraMidia = baseadoOutraMidia;
		this.nota = nota;
	}
	
	public abstract int quantidadeDiasProducao();
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	public String getGenero() {
		return genero;
	}

	
	public boolean isBaseadoOutraMidia() {
		return baseadoOutraMidia;
	}
	
	public double getNota() {
		return nota;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(id);
		sb.append(";");
		sb.append(nome);
		sb.append(";");
		sb.append(genero);
		sb.append(";");
		sb.append(baseadoOutraMidia);
		sb.append(";");
		sb.append(nota);
		
		return sb.toString();
	}

}
