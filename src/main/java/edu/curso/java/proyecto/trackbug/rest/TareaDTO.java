package edu.curso.java.proyecto.trackbug.rest;

import java.util.Set;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.EstadoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.TipoDeTarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public class TareaDTO {
	private Long id;
	private String nombre;
	private Double horasAsignadas;
	private Long idEstado;
	private Long idTipoTarea;

	public TareaDTO() {}
	
	public TareaDTO(Tarea tarea) {
		this.id = tarea.getId();
		this.nombre = tarea.getNombre();
		this.horasAsignadas = tarea.getHorasAsignadas();
		this.idEstado = tarea.getIdEstado();
		this.idTipoTarea = tarea.getIdTipoTarea();
		//this.usuarios = tarea.getUsuarios();
		//this.comentarios = tarea.getComentarios();
	}
	

	
	public Double getHorasAsignadas() {
		return horasAsignadas;
	}
	public void setHorasAsignadas(Double horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
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

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	
	
	
	
}
