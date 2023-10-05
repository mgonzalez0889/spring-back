package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaApplicationPort extends CrudRepository<Factura, Long> {
}
