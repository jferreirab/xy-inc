package com.br.xyinc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.xyinc.model.Poi;
import com.br.xyinc.service.PoiService;
import com.br.xyinc.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class PoiController {
	
	private final PoiService service;
	
	@Autowired
	public PoiController(PoiService service) {
		this.service = service;
	}
	/*
	 * Busca todos os pois cadastrados
	 */
	@RequestMapping(value="/poi", method = RequestMethod.GET)
	public ResponseEntity<List<Poi>> findAll() {
		
		List<Poi> listaPois =   service.buscaTodos();
		
		if(listaPois.isEmpty()) {
			return new ResponseEntity<List<Poi>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Poi>>(listaPois,HttpStatus.OK) ;
	}
	
	/*
	 * salva novo Poi
	 */
	@RequestMapping(value= "/poi", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Poi poi) {
				
		//insere poi
		 try {
			poi = service.salvarPoi(poi);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
		}
		 
		 if(poi == null){
			return new ResponseEntity<>(new CustomErrorType("Erro ao Gravar Poi!"), HttpStatus.NOT_FOUND);
		 }
		
		return new ResponseEntity<Poi>(poi,HttpStatus.OK);
	}
	
	/*
	 * dado a coordenada x e uma coordenada y e a distância máxima 
	 * retorna todos os pois que estão nas proximidades 
	 */
	@RequestMapping(value="poi/{x}/{y}/{dMax}" , method = RequestMethod.GET)
	public ResponseEntity<?> listaPoisPorProximidade(@PathVariable("x") Integer x, @PathVariable("y") Integer y, @PathVariable("dMax") Integer dMax) {
				
		List<Poi> listaPoisRetorno = null;
		try {
			listaPoisRetorno = service.listaPoisPorProximidade(x, y, dMax);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
		}
		
		if(listaPoisRetorno.size() == 0){
			return new ResponseEntity<List<Poi>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Poi>>(listaPoisRetorno,HttpStatus.OK) ;
	}

}
