package com.example.demo.hexadecimal.application;

import com.example.demo.hexadecimal.domain.*;
import com.example.demo.hexadecimal.port.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientApplication implements ClientApplicationPort, UserDetailsService {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(ClientApplication.class);
    private final static String DIRECTORIO_UPLOAD = "uploads";

    @Autowired
    private FacturaApplicationPort facturaApplicationPort;

    @Autowired
    private RegionRepositoryPort regiones;

    @Autowired
    private UsuarioApplicationPort usuarioApplicationPort;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return regiones.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> finAll(Pageable pageable) {
        return regiones.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return regiones.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = false)
    public Cliente save(Cliente cliente) {
        return regiones.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        regiones.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return regiones.findAllRegiones();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaApplicationPort.findById(id).orElse(null);
    }

    @Override
    public Factura saveFacturas(Factura factura) {
        return facturaApplicationPort.save(factura);
    }

    @Override
    public void deleteFacturaById(Long id) {

    }

    @Override
    public List<Producto> findProductoByNombre(String term) {
        return null;
    }

    @Override
    public Resource cargar(String nombreFoto) throws MalformedURLException {
        Path rutaArchivo = getPath(nombreFoto);
        log.info(rutaArchivo.toString());

        Resource recurso =  new UrlResource(rutaArchivo.toUri());
        if(!recurso.exists() && !recurso.isReadable()) {
            rutaArchivo = Paths.get("src/main/resources/static/images").resolve("not-user.png").toAbsolutePath();

            recurso = new UrlResource(rutaArchivo.toUri());


            log.error("Error no se pudo cargar la imagen" + nombreFoto);
        }

        return recurso;
    }

    @Override
    public String copiar(MultipartFile archivo) throws IOException {
        String nombreArchivo = UUID.randomUUID().toString() + "_"+ archivo.getOriginalFilename().replace(" ","");
        Path rutaArchivo = getPath(nombreArchivo);

        log.info(rutaArchivo.toString());

        Files.copy(archivo.getInputStream(), rutaArchivo );

        return nombreArchivo;
    }

    @Override
    public boolean eliminar(String nombreFoto) {
        if(nombreFoto !=null && nombreFoto.length() > 0) {
            Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
            File archivoFotoAnterior = rutaFotoAnterior.toFile();

            if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                archivoFotoAnterior.delete();
                return true;

            }
        }
        return false;
    }

    @Override
    public Path getPath(String nombreFoto) {
        // TODO Auto-generated method stub
        return  Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
    }


    @Override
    @Transactional(readOnly=true)
    public Usuario findByUsername(String username) {
        return usuarioApplicationPort.findByUsername(username);
    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioApplicationPort.findByUsername(username);
        if(usuario == null) {
            log.error("Error en el login: no existe el usuario '" + username + "' en el sistema! ");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username + "' en el sistema! ");
        }
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> log.info("Role" + authority.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }


}
