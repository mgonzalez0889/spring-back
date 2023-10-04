package com.example.hexadecimal.port;

import com.example.hexadecimal.domain.Cliente;

import java.util.List;

public interface ClientApplicationPort {

    List<Cliente> findAll();

}
