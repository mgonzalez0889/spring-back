package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductosApplicationPort extends CrudRepository<Producto, Long> {
    @Query("select p from Productos p where p.nombre like ?1%")
    public List<Producto> findByNombre(String term);

    public List<Producto> findByNombreContainingIgnoreCase(String term);

    public List<Producto> findByNombreStartingWithIgnoreCase(String term);

}
