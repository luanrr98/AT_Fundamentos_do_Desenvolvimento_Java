package br.edu.infnet.appbiblioteca.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Biblioteca;
import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.exceptions.FrequenciaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.QuantidadeInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.TipoAnimacaoInvalidaException;

public class BibliotecaTeste {
	public static void main(String[] args) {
		
		Anime anime = new Anime(8, "Shigofumi", "Slice of Life", false, 9);
		try {
			anime.setNumeroEpisodios(12);
			anime.setNumeroTemporadas(1);
			anime.setTipoAnimacao("2D");
		} catch (QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		Manga manga = new Manga(56,"getsuyoubi no tomodachi", "Slice of Life/ Ficção", false, 8);
		try {
			manga.setFrequenciaEstimadaLancamento("Quinzenal");
			manga.setQuantidadeCapitulos(10);
			manga.setQuantidadeVolumes(1);
			} catch (FrequenciaInvalidaException | QuantidadeInvalidaException e) {
				System.out.println(e.getMessage());
			}
		
		Jogo jogo = new Jogo(45,"Shantae", "Aventura/Plataforma", false, 9);
		try {
			jogo.setEngine("Godot");
			jogo.setMultijogador(false);
			jogo.setPlataforma("PC");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<Midia> jogos = new ArrayList<Midia>();
		jogos.add(jogo);
		
		List<Midia> animeManga =  new ArrayList<Midia>();
		animeManga.add(anime);
		animeManga.add(manga);
		
		Responsavel responsavel = new Responsavel("Luan", "luan@luan", 23);
		
		Biblioteca biblioteca1 = new Biblioteca();
		biblioteca1.setVisibilidade("Pública");
		biblioteca1.setTitulo("Minha_Biblioteca");
		biblioteca1.setResponsavel(responsavel);
		biblioteca1.setMidias(jogos);
		System.out.println(biblioteca1);
		
		Biblioteca biblioteca2 = new Biblioteca();
		biblioteca2.setVisibilidade("Privada");
		biblioteca2.setTitulo("Biblioteca_Pessoal");
		biblioteca2.setResponsavel(responsavel);
		biblioteca2.setMidias(animeManga);
		System.out.println(biblioteca2);
		
		
		
	}

}
