package com.example.hexadecimal.port;

import com.example.hexadecimal.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientApplicationPort {

    List<Cliente> findAll();

    Page<Cliente> finAll(Pageable pageable);

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    void delete(Long id);

}
