package com.br.xyinc.service;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.xyinc.service.CalculaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculaServiceTests {
	

	@Test
	public void distanciaEntrePontosTest() {
		Map<String, Integer> pontoA = new HashMap<>();
		pontoA.put("x",10);
		pontoA.put("y", 20);
		
		Map<String, Integer> pontoB = new HashMap<>();
		pontoB.put("x", 20);
		pontoB.put("y", 20);
		
		CalculaServiceImpl calcula = new CalculaServiceImpl();
		Long distancia = calcula.calculaDistanciaEntreDoisPontos(pontoA, pontoB);
		
		assertNotNull("erro resultado não pode ser null", distancia);
		assertTrue("Erro de distancia", distancia == 10);
		
	}
	
	@Test
	public void distanciaEntreDoisPontosMenorqueTest() {
		Map<String, Integer> pontoA = new HashMap<>();
		pontoA.put("x",10);
		pontoA.put("y", 20);
		
		Map<String, Integer> pontoB = new HashMap<>();
		pontoB.put("x", 20);
		pontoB.put("y", 20);
		
		CalculaServiceImpl calcula = new CalculaServiceImpl();
		
		//valida se o retorno é verdadeiro para distância igual ao máximo
		Boolean retorno = calcula.distanciaEntreDoisPontosMenorque(pontoA, pontoB, 10);
		assertTrue("Distancia é igual  retornar true.", retorno == true);
		
		//valida se o retorno é falso para distância maior que o máximo
		retorno = calcula.distanciaEntreDoisPontosMenorque(pontoA, pontoB, 8);
		assertTrue("Distancia é maior que o máximo retorna false.", retorno == false);
		
		//valida se o retorno é verdadeiro para distância menor que o máximo  
		retorno = calcula.distanciaEntreDoisPontosMenorque(pontoA, pontoB, 11);
		assertTrue("Distancia é menor que o máximo retorna true.", retorno == true);
		
	}
}
