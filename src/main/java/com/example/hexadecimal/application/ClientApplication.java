package com.example.hexadecimal.application;

import com.example.hexadecimal.domain.Cliente;
import com.example.hexadecimal.port.ClientApplicationPort;
import com.example.hexadecimal.port.RegionRepositoryPort;
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
    @Transactional(readOnly = false)
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


}
