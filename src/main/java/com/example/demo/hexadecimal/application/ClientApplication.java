package com.example.demo.hexadecimal.application;

import com.example.demo.hexadecimal.domain.Cliente;
import com.example.demo.hexadecimal.domain.Factura;
import com.example.demo.hexadecimal.domain.Producto;
import com.example.demo.hexadecimal.domain.Region;
import com.example.demo.hexadecimal.port.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientApplication implements ClientApplicationPort {

    @Autowired
    private RegionRepositoryPort region;

    @Autowired
    private FacturaApplicationPort facturaPort;

    @Autowired
    private ProductosApplicationPort productosPort;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return region.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> finAll(Pageable pageable) {
        return region.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return region.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = false)
    public Cliente save(Cliente cliente) {
        return region.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        region.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return region.findAllRegiones();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaPort.findById(id).orElse(null);
    }

    @Override
    public Factura saveFacturas(Factura factura) {
        return facturaPort.save(factura);
    }

    @Override
    public void deleteFacturasById(Long id) {
        facturaPort.deleteById(id);;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductosByNombre(String term) {
        return productosPort.findByNombreContainingIgnoreCase(term);
    }


}
