package com.example.demo.models.dao.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.entity.Clientes;
import com.example.demo.models.entity.Facturas;
import com.example.demo.models.entity.Productos;
import com.example.demo.models.entity.Regiones;

public interface IClienteService {
	
	public List<Clientes> finAll();
	
	public Page<Clientes> finAll(Pageable pageable);
	
	public Clientes findById(Long id);
	
	public Clientes save(Clientes clientes);
	
	public void delete(Long id);
	
	public List<Regiones> findAllRegiones();
	
	public Facturas findFacturaById(Long id);
	
	public Facturas saveFactura(Facturas facturas);
	
	public void deleteFacturaById(Long id);
	
	public List<Productos> findProductoByNombre(String term);
	
	
	

}
