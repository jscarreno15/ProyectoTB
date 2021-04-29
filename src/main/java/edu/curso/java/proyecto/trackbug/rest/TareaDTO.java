package edu.curso.java.proyecto.trackbug.rest;

import java.util.Set;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.EstadoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.TipoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public class TareaDTO {
	private Long id;
	private String nombre;
	private Double horasAsignadas;
	private UsuarioDTO usuarioDTO;
	private Long duracion;
	//private EstadoDeTarea estado;
	//private Set<Usuario> usuarios;
	//private Set<Comentario> comentarios;
	
	public TareaDTO() {}
	
	public TareaDTO(Tarea tarea) {
		this.id = tarea.getId();
		this.nombre = tarea.getNombre();
		this.horasAsignadas = tarea.getHorasAsignadas();
		//this.estado = tarea.getEstado();
		//this.usuarios = tarea.getUsuarios();
		//this.comentarios = tarea.getComentarios();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getHorasAsignadas() {
		return horasAsignadas;
	}
	public void setHorasAsignadas(Double horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}
	
	
	
}
