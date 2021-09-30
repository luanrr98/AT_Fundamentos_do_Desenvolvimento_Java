package br.edu.infnet.appbiblioteca.model.domain;

import br.edu.infnet.appbiblioteca.model.exceptions.QuantidadeInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.TipoAnimacaoInvalidaException;

public class Anime extends Midia {
	
	private int numeroEpisodios;
	private int numeroTemporadas;
	private String tipoAnimacao;
	

	public Anime(int id, String nome, String genero, boolean baseadoOutraMidia, double nota) {
		super(id, nome, genero, baseadoOutraMidia, nota);
	}

	@Override
	public int quantidadeDiasProducao() {
		return getNumeroEpisodios() * 
				((isBaseadoOutraMidia() ? -2 : 0) 
				+ (tipoAnimacao.equals("3D") ? 5 : 7 ));
	}

	public int getNumeroEpisodios() {
		return numeroEpisodios;
	}


	public void setNumeroEpisodios(int numeroEpisodios) throws QuantidadeInvalidaException {
		if(numeroEpisodios <= 0) {
			throw  new QuantidadeInvalidaException(getNome() + ": A quantidade de Episodios é inválida");
		}
		
		this.numeroEpisodios = numeroEpisodios;
	}


	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}


	public void setNumeroTemporadas(int numeroTemporadas) throws QuantidadeInvalidaException {
		if(numeroTemporadas <= 0) {
			throw  new QuantidadeInvalidaException(getNome() + ": A quantidade de Temporadas é inválida");
		}
		
		this.numeroTemporadas = numeroTemporadas;
	}


	public String getTipoAnimacao() {
		return tipoAnimacao;
	}


	public void setTipoAnimacao(String tipoAnimacao) throws TipoAnimacaoInvalidaException {
		if(!"2D".equals(tipoAnimacao) && !"3D".equals(tipoAnimacao)) {
			throw new TipoAnimacaoInvalidaException(getNome() + ": O tipo de animação deve ser 2D ou 3D");
		}
		
		this.tipoAnimacao = tipoAnimacao;
	}


	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(";");
		sb.append(tipoAnimacao);
		sb.append(";");
		sb.append(numeroTemporadas);
		sb.append(";");
		sb.append(numeroEpisodios);
		sb.append(";");
		sb.append(quantidadeDiasProducao());
		return sb.toString();
	}
}
