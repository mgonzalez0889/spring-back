package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Cliente;
import com.example.demo.hexadecimal.domain.Factura;
import com.example.demo.hexadecimal.domain.Producto;
import com.example.demo.hexadecimal.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientApplicationPort {

    List<Cliente> findAll();

    Page<Cliente> finAll(Pageable pageable);

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    void delete(Long id);

    List<Region> findAllRegiones();

    Factura findFacturaById(Long id);

    Factura saveFacturas(Factura factura);

    void deleteFacturaById(Long id);

    List<Producto> findProductoByNombre(String term);

}
