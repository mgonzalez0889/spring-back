package com.example.demo.hexadecimal.port;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface UploadRepositoryPort {
    Resource cargar(String nombreFoto) throws MalformedURLException;
    String copiar (MultipartFile archivo) throws IOException;
    boolean eliminar (String nombreFoto);
    Path getPath(String nombreFoto);
}
