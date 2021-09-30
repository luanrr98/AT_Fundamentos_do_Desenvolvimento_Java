package br.edu.infnet.appbiblioteca.model.domain;

import br.edu.infnet.appbiblioteca.model.exceptions.PlataformaInvalidaException;

public class Jogo extends Midia {

	private String plataforma;
	private String engine;
	private  boolean multijogador;
	
	public Jogo(int id, String nome, String genero, boolean baseadoOutraMidia, double nota) {
		super(id, nome, genero, baseadoOutraMidia, nota);
	}

	@Override
	public int quantidadeDiasProducao() {
		return (multijogador ? 50 : 0) + (isBaseadoOutraMidia() ? 350 : 500);
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) throws PlataformaInvalidaException {
		if(!"PC".equals(plataforma) && !"PS5".equals(plataforma) && !"XBOX".equals(plataforma) && !"SWITCH".equals(plataforma)) {
			throw new PlataformaInvalidaException(getNome() + ": A plataforma deve ser PC, SWITCH, XBOX ou PS5!");
		}
			
		this.plataforma = plataforma;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public boolean isMultijogador() {
		return multijogador;
	}

	public void setMultijogador(boolean multijogador) {
		this.multijogador = multijogador;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(";");
		sb.append(plataforma);
		sb.append(";");
		sb.append(engine);
		sb.append(";");
		sb.append(multijogador);
		sb.append(";");
		sb.append(quantidadeDiasProducao());
		
		return sb.toString();
	}
	
	

}
