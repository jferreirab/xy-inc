package com.br.xyinc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.xyinc.model.Poi;
import com.br.xyinc.repository.PoiRepository;

@Service
public class PoiServiceImpl implements PoiService {
	
	@Autowired
	private  PoiRepository repository;
	@Autowired
	private CalculaService calculaService;
	
	/*
	 * (non-Javadoc)
	 * @see com.br.xyinc.service.PoiService#buscaTodos()
	 * retorna todos os Pois cadastrados
	 */
	public List<Poi> buscaTodos(){		
		
		return repository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.br.xyinc.service.PoiService#verifcaPoiCadastrado(com.br.xyinc.model.Poi)
	 * retorna se o poi já foi cadastrado
	 */
	public Boolean verifcaPoiCadastrado(Poi poi) {
		
		Long count = repository.countByPoi(poi.getDescricao(), poi.getX(), poi.getY());
		
		if(count > 0){
			return true;
		}
		
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.br.xyinc.service.PoiService#salvarPoi(com.br.xyinc.model.Poi)
	 * salva um novo POI
	 */
	public Poi salvarPoi(Poi poi) throws Exception{
		
		//verifica se coordenada x é difierente de nullo e se é maior que zero
		if(poi.getX() != null && poi.getX() < 0 ) 
			throw new Exception("Coordenada x não pode ser negativa.");
		else if(poi.getX() == null)	
			throw new Exception("Coordenada x não foi informada.");
		
		//verifica se coordenada y é difierente de nullo e se é maior que zero
		if(poi.getY() != null && poi.getY() < 0)			
			throw new Exception("Coordenada Y não pode ser negativa!");
		else if(poi.getY() == null)
			throw new Exception("Coordenada Y não foi informado!");
		
		//verifica se foi informado a descrição do POI
		if(poi.getDescricao() == null || poi.getDescricao().equals(""))
			throw new Exception("Descrição do POI não foi informada!");
		
		//verifica se  o Poi já foi cadastrado		
		if(verifcaPoiCadastrado(poi) ) {
			throw new Exception("POI já cadastrado!");
		}
		return repository.save(poi);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.br.xyinc.service.PoiService#listaPoisPorProximidade(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 * retorna a lista de POIs por proximidade da coordenada x e y 
	 */
	public List<Poi> listaPoisPorProximidade(Integer x, Integer y, Integer dMax )throws Exception{
		
		//verifica se coordenada x é positiva
		if(x < 0 ) 
			throw new Exception("Coordenada x não pode ser negativa.");
		
		//verifica se coordenada y é positiva
		if(y < 0)			
			throw new Exception("Coordenada Y não pode ser negativa!");
	    //verifica se distância máxima é positiva
		if(dMax < 0 )
			throw new Exception("Distância máxima não pode ser negativa!");
		
		List<Poi> listaTodosPois =  repository.findAll();
		List<Poi> listaPoisRetorno = new ArrayList<>();
		
		Map<String, Integer> pontoA = new HashMap<>();
		pontoA.put("x", x);
		pontoA.put("y", y);
		for(Poi poi : listaTodosPois) {
			Map<String, Integer> pontoB = new HashMap<>();
			pontoB.put("x", poi.getX());
			pontoB.put("y", poi.getY());			
			if(calculaService.distanciaEntreDoisPontosMenorque(pontoA, pontoB, dMax)) {
				listaPoisRetorno.add(poi);
			}
		}
		return listaPoisRetorno;
	}

}
