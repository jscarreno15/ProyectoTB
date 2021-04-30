package edu.curso.java.proyecto.trackbug.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.repository.ComentarioRepository;
import edu.curso.java.proyecto.trackbug.rest.ComentarioService;

@Service
@Transactional
public class ComentarioServiceImp implements ComentarioService{

	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Override
	public Comentario guardarComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
		
	}

	@Override
	public void borrarComentario(Long id) {
		comentarioRepository.deleteById(id);
		
	}

}
