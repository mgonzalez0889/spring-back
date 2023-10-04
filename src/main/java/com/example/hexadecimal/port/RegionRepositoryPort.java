package com.example.hexadecimal.port;

import com.example.hexadecimal.domain.Cliente;
import com.example.hexadecimal.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepositoryPort extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    List<Region> findAllRegiones();
}
