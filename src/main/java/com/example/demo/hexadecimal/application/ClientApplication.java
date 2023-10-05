package com.example.demo.hexadecimal.application;

import com.example.demo.hexadecimal.domain.Clientes;
import com.example.demo.hexadecimal.domain.Facturas;
import com.example.demo.hexadecimal.domain.Productos;
import com.example.demo.hexadecimal.domain.Regions;
import com.example.demo.hexadecimal.port.ClientApplicationPort;
import com.example.demo.hexadecimal.port.FacturaApplicationPort;
import com.example.demo.hexadecimal.port.ProductosApplicationPort;
import com.example.demo.hexadecimal.port.RegionRepositoryPort;
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
    public List<Clientes> findAll() {
        return region.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Clientes> finAll(Pageable pageable) {
        return region.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes findById(Long id) {
        return region.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = false)
    public Clientes save(Clientes clientes) {
        return region.save(clientes);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        region.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Regions> findAllRegiones() {
        return region.findAllRegiones();
    }

    @Override
    @Transactional(readOnly = true)
    public Facturas findFacturaById(Long id) {
        return facturaPort.findById(id).orElse(null);
    }

    @Override
    public Facturas saveFacturas(Facturas factura) {
        return facturaPort.save(factura);
    }

    @Override
    public void deleteFacturasById(Long id) {
        facturaPort.deleteById(id);;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> findProductosByNombre(String term) {
        return productosPort.findByNombreContainingIgnoreCase(term);
    }


}
