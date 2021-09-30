package br.edu.infnet.appbiblioteca.model.domain;

import br.edu.infnet.appbiblioteca.model.exceptions.FrequenciaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.QuantidadeInvalidaException;

public class Manga extends Midia {
	
	private int quantidadeCapitulos;
	private int quantidadeVolumes;
	private String frequenciaEstimadaLancamento;
	
		
	public Manga(int id, String nome, String genero, boolean baseadoOutraMidia, double nota) {
		super(id, nome, genero, baseadoOutraMidia, nota);
	}
	
	@Override
	public int quantidadeDiasProducao() {
		return getQuantidadeCapitulos() *
				((frequenciaEstimadaLancamento.equals("Mensal") ? 30 : 15) 
				+ (isBaseadoOutraMidia() ? -5 : 0 ));
	}

	public int getQuantidadeCapitulos() {
		return quantidadeCapitulos;
	}

	public void setQuantidadeCapitulos(int quantidadeCapitulos) throws QuantidadeInvalidaException {
		if(quantidadeCapitulos <= 0) {
			throw new QuantidadeInvalidaException(getNome() + ": A quantidade de capítulos é inválida!");
		}
		
		this.quantidadeCapitulos = quantidadeCapitulos;
	}

	public int getQuantidadeVolumes() {
		return quantidadeVolumes;
	}

	public void setQuantidadeVolumes(int quantidadeVolumes) throws QuantidadeInvalidaException {
		if(quantidadeVolumes <= 0) {
			throw new QuantidadeInvalidaException(getNome() +": A quantidade de volumes é inválida!");
		}
		
		this.quantidadeVolumes = quantidadeVolumes;
	}



	public String getFrequenciaEstimadaLancamento() {
		return frequenciaEstimadaLancamento;
	}

	public void setFrequenciaEstimadaLancamento(String frequenciaEstimadaLancamento) throws FrequenciaInvalidaException {
		if(!"Mensal".equals(frequenciaEstimadaLancamento) && !"Quinzenal".equals(frequenciaEstimadaLancamento)) {
			throw new FrequenciaInvalidaException(getNome() + ": A frequência de lançamento deve ser Mensal ou Quinzenal");

		}
		this.frequenciaEstimadaLancamento = frequenciaEstimadaLancamento;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(";");
		sb.append(frequenciaEstimadaLancamento);
		sb.append(";");
		sb.append(quantidadeVolumes);
		sb.append(";");
		sb.append(quantidadeCapitulos);
		sb.append(";");
		sb.append(quantidadeDiasProducao());
		
		return sb.toString();
	}
}
