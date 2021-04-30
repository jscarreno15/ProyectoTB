package edu.curso.java.proyecto.trackbug.rest;

import edu.curso.java.proyecto.trackbug.bo.Comentario;

public interface ComentarioService {

	public Comentario guardarComentario(Comentario comentario);
	public void borrarComentario(Long id);
}
