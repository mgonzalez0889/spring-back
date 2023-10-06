package com.example.demo.hexadecimal.port;

import com.example.demo.hexadecimal.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioApplicationPort extends CrudRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    Usuario findByUsernameOther(String username);
}
