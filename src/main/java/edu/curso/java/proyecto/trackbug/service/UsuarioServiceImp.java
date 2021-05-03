package edu.curso.java.proyecto.trackbug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.Usuario;
import edu.curso.java.proyecto.trackbug.repository.ComentarioRepository;
import edu.curso.java.proyecto.trackbug.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
		

	@Override
	public Long crearUsuario(Usuario usuario) {	
		return usuarioRepository.save(usuario).getId();
	}


	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		return usuarios;
	}


	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).get();
	}


	@Override
	public void cargarComentario(Comentario comentario) {
		comentarioRepository.save(comentario);
		
	}


}
