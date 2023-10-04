package com.example.hexadecimal.application;

import com.example.hexadecimal.domain.Cliente;
import com.example.hexadecimal.port.ClientApplicationPort;
import com.example.hexadecimal.port.RegionRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientApplication implements ClientApplicationPort {

    @Autowired
    private RegionRepositoryPort region;
    @Override
    public List<Cliente> findAll() {
        return region.findAll();
    }
}
