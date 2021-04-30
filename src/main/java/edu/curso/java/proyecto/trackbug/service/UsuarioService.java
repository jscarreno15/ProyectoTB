package edu.curso.java.proyecto.trackbug.service;

import java.util.List;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.Usuario;


public interface UsuarioService {
	
	public Long crearUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public Usuario listarUsuarioPorId(Long id);
	public void cargarComentario(Comentario comentario);

}
