/**
 * 
 */
package com.br.xyinc.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author juliano ferreira borges
 *
 */
@Service
public class CalculaServiceImpl implements CalculaService {

	/*
	 * calcula distancia entre dois pontos
	 */
	public Long calculaDistanciaEntreDoisPontos(Map<String, Integer> pontoA, Map<String, Integer> pontoB) {
	
		double distancia = Math.sqrt(Math.pow((pontoB.get("x")- pontoA.get("x")),2) +Math.pow((pontoB.get("y")- pontoA.get("y")),2) ); 
		return Math.abs(Math.round(distancia));
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.br.xyinc.service.CalculaService#distanciaEntreDoisPontosMenorque(java.util.Map, java.util.Map, java.lang.Integer)
	 * retorna se a distancia entre dois pontos é menor ou igual a uma distância máxima.
	 */
	public Boolean distanciaEntreDoisPontosMenorque(Map<String, Integer> pontoA, Map<String, Integer> pontoB ,Integer dMax) {
		
		if(calculaDistanciaEntreDoisPontos(pontoA, pontoB) <= dMax) 
			return true;
		else
			return false;
	}
}
