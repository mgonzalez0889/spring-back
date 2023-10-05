package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Productos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductosApplicationPort extends CrudRepository<Productos, Long> {
    @Query("select p from Producto p where p.nombre like ?1%")
    public List<Productos> findByNombre(String term);

    public List<Productos> findByNombreContainingIgnoreCase(String term);

    public List<Productos> findByNombreStartingWithIgnoreCase(String term);

}
