package com.example.demo.hexadecimal.application;

import com.example.demo.hexadecimal.domain.Factura;
import com.example.demo.hexadecimal.port.FacturaApplicationPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FacturaApplication implements FacturaApplicationPort {
    @Override
    public <S extends Factura> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Factura> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Factura> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Factura> findAll() {
        return null;
    }

    @Override
    public Iterable<Factura> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Factura entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Factura> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
