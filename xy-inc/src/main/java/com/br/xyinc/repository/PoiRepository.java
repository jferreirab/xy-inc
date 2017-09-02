package com.br.xyinc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.xyinc.model.Poi;

@Repository
public interface PoiRepository extends JpaRepository<Poi, Long> {
	
	/**
     * Método que retorna quantidade de POIs cadastrados para uma coordenada x,y e descrição.
     * 
     * @param descrição
     * @param x
     * @param y
     * @return quantidade de POIs para os parametros passados.
     */   
    @Query("SELECT count(p) FROM Poi p where p.descricao = :descricao and p.x = :x and p.y = :y") 
    public Long countByPoi(@Param("descricao") String descricao, @Param("x") Integer x, @Param("y") Integer y);
}
