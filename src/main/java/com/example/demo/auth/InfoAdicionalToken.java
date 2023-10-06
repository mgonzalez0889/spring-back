package com.example.demo.auth;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.hexadecimal.domain.Usuario;
import com.example.demo.hexadecimal.port.UsuarioApplicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;


@Component
public class InfoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private UsuarioApplicationPort usuarioApplicationPort;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioApplicationPort.findByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Cualquier!: ".concat(authentication.getName()));
		
		info.put("nombre", usuario.getNombre());
		info.put("apellido",  usuario.getApellido());
		info.put("email", usuario.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
