package br.edu.infnet.appbiblioteca.model.testes;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.exceptions.FrequenciaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.PlataformaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.QuantidadeInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.TipoAnimacaoInvalidaException;

public class MidiaTeste {
	
	public static void main(String[] args) {
		try{
			Jogo jogo = new Jogo(7, "Castlevania", "MetroidVania", false, 8);
			jogo.setEngine("Godot");
			jogo.setPlataforma("PC");
			jogo.setMultijogador(false);
			System.out.println(jogo);
		}catch(PlataformaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		//Errando para Mostrar Excessão
		try{
			Jogo jogo2 = new Jogo(6, "Bloodstained", "ClassicVania", false, 8);
			jogo2.setEngine("Unity");
			jogo2.setPlataforma("Snes");
			jogo2.setMultijogador(false);
			System.out.println(jogo2);
		}catch(PlataformaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try{
			Anime anime = new Anime(66, "Naruto", "Ação", true, 9);
			anime.setNumeroEpisodios(300);
			anime.setNumeroTemporadas(5);
			anime.setTipoAnimacao("2D");
			System.out.println(anime);
		}catch(QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		//Errando para Mostrar Excessão
		try{
			Anime anime2 = new Anime(41, "91 Days", "Ação", false, 7);
			anime2.setNumeroEpisodios(0);
			anime2.setNumeroTemporadas(5);
			anime2.setTipoAnimacao("2D");
			System.out.println(anime2);
		}catch(QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		//Errando para Mostrar Excessão
		try{
			Anime anime3 = new Anime(41, "Mayoiga", "Suspense", false, 4);
			anime3.setNumeroEpisodios(12);
			anime3.setNumeroTemporadas(0);
			anime3.setTipoAnimacao("3D");
			System.out.println(anime3);
		}catch(QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try{
			Anime anime4 = new Anime(41, "Boruto", "Aventura", false, 8);
			anime4.setNumeroEpisodios(88);
			anime4.setNumeroTemporadas(7);
			anime4.setTipoAnimacao("9D");
			System.out.println(anime4);
		}catch(QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Manga manga = new Manga(99, "The Witcher", "Ação/Medieval", true, 9);
			manga.setFrequenciaEstimadaLancamento("Quinzenal");
			manga.setQuantidadeCapitulos(8);
			manga.setQuantidadeVolumes(1);
			System.out.println(manga);
		}catch(FrequenciaInvalidaException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		//Errando para Mostrar Excessão
		try {
			Manga manga2 = new Manga(99, "Dragon Ball", "Aventura/Ação", false, 9);
			manga2.setFrequenciaEstimadaLancamento("Bimestral");
			manga2.setQuantidadeCapitulos(200);
			manga2.setQuantidadeVolumes(27);
			System.out.println(manga2);
		}catch(FrequenciaInvalidaException | QuantidadeInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
