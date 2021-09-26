package br.edu.infnet.appbiblioteca.model.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appbiblioteca.model.domain.Anime;
import br.edu.infnet.appbiblioteca.model.domain.Biblioteca;
import br.edu.infnet.appbiblioteca.model.domain.Jogo;
import br.edu.infnet.appbiblioteca.model.domain.Manga;
import br.edu.infnet.appbiblioteca.model.domain.Midia;
import br.edu.infnet.appbiblioteca.model.domain.Responsavel;
import br.edu.infnet.appbiblioteca.model.exceptions.FrequenciaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.PlataformaInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.QuantidadeInvalidaException;
import br.edu.infnet.appbiblioteca.model.exceptions.TipoAnimacaoInvalidaException;

public class ArquivoTeste {
	
	public static void main(String[] args) {
		
		String dir = "D:/at/appbiblioteca/";
		String arq = "biblioteca.txt";
		
		try {
			try{
			FileReader file = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(file);
			
			FileWriter fileWr = new FileWriter(dir+"out_"+arq);
			BufferedWriter escrita = new BufferedWriter(fileWr);
			
			String linha = null;
			String [] campos;
			
			linha = leitura.readLine();
			
			List<Midia> midias = new ArrayList<Midia>();
			
			Biblioteca biblioteca = new Biblioteca();
			
			
			while(linha != null) {
				
				campos = linha.split(";");
				
				if(campos.length == 5) {
					Responsavel responsavel = new Responsavel(campos[2], 
							campos[3], 
							Integer.valueOf(campos[4]));
					
					biblioteca.setTitulo(campos[0]);
					biblioteca.setVisibilidade(campos[1]);
					biblioteca.setResponsavel(responsavel);
				}else {
					switch(campos[0]) {
						case "Manga":
							Manga manga = new Manga(
									Integer.valueOf(campos[1]), 
									campos[2], 
									campos[3], 
									Boolean.valueOf(campos[4]), 
									Double.valueOf(campos[5]));
							try {
								manga.setFrequenciaEstimadaLancamento(campos[6]);
								manga.setQuantidadeVolumes(Integer.valueOf(campos[7]));
								manga.setQuantidadeCapitulos(Integer.valueOf(campos[8]));
								midias.add(manga);
							} catch (FrequenciaInvalidaException | QuantidadeInvalidaException e) {
								System.out.println(e.getMessage());
							}

							break;
						
						case "Anime":
							Anime anime = new Anime(
									Integer.valueOf(campos[1]), 
									campos[2], 
									campos[3], 
									Boolean.valueOf(campos[4]), 
									Double.valueOf(campos[5]));
							try {
								anime.setTipoAnimacao(campos[6]);
								anime.setNumeroTemporadas(Integer.valueOf(campos[7]));
								anime.setNumeroEpisodios(Integer.valueOf(campos[8]));
								midias.add(anime);
	
							} catch (NumberFormatException | QuantidadeInvalidaException | TipoAnimacaoInvalidaException e) {
								System.out.println(e.getMessage());
							}

							break;
							
						case "Jogo":
							Jogo jogo = new Jogo(
									Integer.valueOf(campos[1]), 
									campos[2], 
									campos[3], 
									Boolean.valueOf(campos[4]), 
									Double.valueOf(campos[5]));
							try {
								jogo.setPlataforma(campos[6]);
								jogo.setEngine(campos[7]);
								jogo.setMultijogador(Boolean.valueOf(campos[8]));
								midias.add(jogo);
							} catch (PlataformaInvalidaException e) {
								System.out.println(e.getMessage());
	
							}

							break;
								
							
						default:
							System.out.println("Mídia Inválida");
							break;
					}	
				}
				
				linha = leitura.readLine();
			}
			biblioteca.setMidias(midias);
			
			for(Midia midia: midias) {
				escrita.write(
						biblioteca.getTitulo()+";"+
						biblioteca.getResponsavel().getNome()+";"+
						midia.getNome()+";"+
						midia.quantidadeDiasProducao()+"\n"
						);
			}

			leitura.close();
			file.close();
			
			escrita.close();
			fileWr.close();
						
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}finally {
			System.out.println("Processamento Realizado");
		}
				
	}
}
