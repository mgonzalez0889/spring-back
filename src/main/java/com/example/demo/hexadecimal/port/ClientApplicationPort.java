package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.*;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;

public interface ClientApplicationPort {

    List<Cliente> findAll();

    Page<Cliente> finAll(Pageable pageable);

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    void delete(Long id);

    List<Region> findAllRegiones();

    Factura findFacturaById(Long id);

    Factura saveFacturas(Factura factura);

    void deleteFacturaById(Long id);

    List<Producto> findProductoByNombre(String term);

    Resource cargar(String nombreFoto) throws MalformedURLException;
    String copiar (MultipartFile archivo) throws IOException;
    boolean eliminar (String nombreFoto);
    Path getPath(String nombreFoto);

    Usuario findByUsername(String username);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
