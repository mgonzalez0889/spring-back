package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Clientes;
import com.example.demo.hexadecimal.domain.Facturas;
import com.example.demo.hexadecimal.domain.Productos;
import com.example.demo.hexadecimal.domain.Regions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientApplicationPort {

    List<Clientes> findAll();

    Page<Clientes> finAll(Pageable pageable);

    Clientes findById(Long id);

    Clientes save(Clientes clientes);

    void delete(Long id);

    List<Regions> findAllRegiones();

    Facturas findFacturaById(Long id);

    Facturas saveFacturas(Facturas factura);

    void deleteFacturasById(Long id);

    List<Productos> findProductosByNombre(String term);

}
