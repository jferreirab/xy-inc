package com.br.xyinc.service;

import java.util.List;


import com.br.xyinc.model.Poi;


public interface PoiService {
	
	public List<Poi> buscaTodos();
	public Boolean verifcaPoiCadastrado(Poi poi);
	public Poi salvarPoi(Poi poi) throws Exception;
	public List<Poi> listaPoisPorProximidade(Integer x, Integer y, Integer dMax )throws Exception;

}
