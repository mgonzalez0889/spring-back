package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.entity.Clientes;
import com.example.demo.models.entity.Regiones;

public interface IClienteDao  extends JpaRepository<Clientes, Long>{
	
	@Query("from Regiones")
	public List<Regiones> findAllRegiones();

}
