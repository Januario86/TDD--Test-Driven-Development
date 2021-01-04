package br.com.caelum.leilao.teste;

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
		
		System.out.println(maiorEsperado);
		System.out.println(menorEsperado);
		
		//System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.00001);
		
		//System.out.println(menorEsperado == leiloeiro.getMenorLance());
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(),0.00001);
		

	}

}
