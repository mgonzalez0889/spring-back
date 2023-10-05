package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Facturas;

public interface IFacturaDao extends CrudRepository<Facturas, Long>{

}
