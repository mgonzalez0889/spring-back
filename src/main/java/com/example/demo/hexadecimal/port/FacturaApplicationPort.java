package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Facturas;
import org.springframework.data.repository.CrudRepository;

public interface FacturaApplicationPort extends CrudRepository<Facturas, Long> {
}
