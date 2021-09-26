package br.edu.infnet.appbiblioteca.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Biblioteca {
	
	private String visibilidade;
	private String titulo;
	private LocalDateTime dataHoraCriacao;
	
	private Responsavel responsavel;
	private List<Midia> midias;
	
	public Biblioteca() {
		this.dataHoraCriacao = LocalDateTime.now();
	}
		
	public String getVisibilidade() {
		return visibilidade;
	}
	
	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;

	}
	
	public List<Midia> getMidias() {
		return midias;
	}
	
	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataHoraCriacao;
	}


	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
		StringBuilder sb = new StringBuilder();
		
		sb.append(dataHoraCriacao.format(formato));
		sb.append(";");
		sb.append(visibilidade);
		sb.append(";");		
		sb.append(titulo);
		sb.append(";");
		sb.append(responsavel.toString());
		sb.append(";");
		if(midias != null) {
			sb.append(midias.size());
		}

		return sb.toString();
	}

	
	
}
