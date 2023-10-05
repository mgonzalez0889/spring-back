package com.example.demo.models.dao.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IClienteDao;
import com.example.demo.models.dao.IFacturaDao;
import com.example.demo.models.entity.Clientes;
import com.example.demo.models.entity.Facturas;
import com.example.demo.models.entity.Productos;
import com.example.demo.models.entity.Regiones;

@Service
public class ClienteServiceImpl implements IClienteService{
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Clientes> finAll() {
		// TODO Auto-generated method stub
		return (List<Clientes>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Clientes> finAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Clientes findById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}
	
	
	@Override
	@Transactional(readOnly = false)
	public Clientes save(Clientes clientes) {
		// TODO Auto-generated method stub
		return clienteDao.save(clientes);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Regiones> findAllRegiones() {
		// TODO Auto-generated method stub
		return clienteDao.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Facturas findFacturaById(Long id) {
	
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Facturas saveFactura(Facturas facturas) {
 
		return facturaDao.save(facturas);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Productos> findProductoByNombre(String term) {

		return productoDao.findByNombreContainingIgnoreCase(term);
	}

	
}
