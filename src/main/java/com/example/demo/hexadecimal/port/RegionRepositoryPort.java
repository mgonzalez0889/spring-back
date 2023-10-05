package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Clientes;
import com.example.demo.hexadecimal.domain.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepositoryPort extends JpaRepository<Clientes, Long> {

    @Query("from Regions")
    List<Regions> findAllRegiones();
}
