package com.itDev.puntoVentas.data.dao;

import javax.persistence.TypedQuery;

import com.itDev.puntoVentas.data.entities.Usuario;

public class UsuarioRepository {
	
	public Usuario getUsuario(String userName, String password) {
		Usuario user= new Usuario();
		//TypedQuery<Usuario>
		return user;
	}

}
