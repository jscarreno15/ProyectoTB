package edu.curso.java.proyecto.trackbug.rest;

import java.util.Set;

import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public class ProyectoDTO {
	
	private Long id;
	private String nombre;
	private Usuario usuarioResponsable;
	private Double horasAsignadasProyecto;
	
	public ProyectoDTO(){}
	
	public ProyectoDTO(Proyecto proyecto) {
		this.id = proyecto.getId();
		this.nombre = proyecto.getNombre();
		this.usuarioResponsable = proyecto.getUsuarioResponsable();
		this.horasAsignadasProyecto = proyecto.getHorasAsignadasProyecto();
	}
	
	
	public Usuario getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public Double getHorasAsignadasProyecto() {
		return horasAsignadasProyecto;
	}

	public void setHorasAsignadasProyecto(Double horasAsignadasProyecto) {
		this.horasAsignadasProyecto = horasAsignadasProyecto;
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

	
}
