package com.example.demo.models.dao.models.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Productos;

public interface IProductoDao extends CrudRepository<Productos, Long> {
	
	@Query("select p from Productos p where p.nombre like ?1%")
	public List<Productos> findByNombre(String term);
	
	
	public List<Productos> findByNombreContainingIgnoreCase(String term);
	
	
	public List<Productos> findByNombreStartingWithIgnoreCase(String term);
		
	

}
