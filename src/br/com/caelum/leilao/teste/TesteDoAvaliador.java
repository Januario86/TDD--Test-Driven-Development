package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
	
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		//System.out.println(maiorEsperado);
		//System.out.println(menorEsperado);
		
		//System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.00001);
		
		//System.out.println(menorEsperado == leiloeiro.getMenorLance());
		assertEquals(menorEsperado, leiloeiro.getMenorLance(),0.00001);
		

	}
	
	@Test
	public void deveEntenderComApenasUmLance() {
	
		Usuario joao = new Usuario("João");
		
		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 1000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(),0.00001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");		
		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(),0.00001);
		assertEquals(300.0, maiores.get(1).getValor(),0.00001);
		assertEquals(200.0, maiores.get(2).getValor(),0.00001);
		
		
	}

}
