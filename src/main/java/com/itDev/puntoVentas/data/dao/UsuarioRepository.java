package com.itDev.puntoVentas.data.dao;

import javax.persistence.TypedQuery;

import com.itDev.puntoVentas.data.entities.Usuario;
import com.itDev.puntoVentas.util.SecurityHelper;

public class UsuarioRepository extends BaseRepository<Usuario> {
	
	public Usuario get(String nombre) {
		Usuario usuario= null;
		TypedQuery<Usuario> qry= eMgr.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class);
		qry.setParameter("nombre", nombre);
		usuario= qry.getSingleResult();
		return usuario;
	}
	
	public Usuario login(String nombre, String password) {
		Usuario usuario= get(nombre);
		if(usuario != null && !SecurityHelper.verificar(password, usuario.getPassword())) {
			usuario=null;
		}
		return usuario;
	}

}
