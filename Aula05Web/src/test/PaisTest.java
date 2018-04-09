package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import model.Pais;
import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PaisTest {
		
		Pais pais, copia;
		PaisService paisservice;
		static int id = 0;
		
	@Test
	void testCriar() {
		System.out.println("criar");
		id = paisservice.criar(pais);
		System.out.println(id);
		Object cliente = null;
		assertEquals("testa criacao", cliente, copia);
	}

	@Test
	void testAtualizar() {
		System.out.println("atualizar");
		pais.setArea(1997338);
		copia.setArea(1997338);
		paisservice.atualizar(pais);
		pais = paisservice.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	void testExcluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao((Long) null);
		copia.setArea((Double) null);
		paisservice.excluir(id);
		pais = paisservice.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}

	@Test
	void testCarregar() {
		
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Egito");
		fixture.setPopulacao(92155000);
		fixture.setArea(1002450);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("teste inclusao", novo, fixture);
		
		
	}

	

}
