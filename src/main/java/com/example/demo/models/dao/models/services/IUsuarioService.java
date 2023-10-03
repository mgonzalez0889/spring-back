package com.example.demo.models.dao.models.services;

import com.example.demo.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
