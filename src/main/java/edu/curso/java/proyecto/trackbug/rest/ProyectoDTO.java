package edu.curso.java.proyecto.trackbug.rest;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public class ProyectoDTO {
	
	private Long id;
	private String nombre;
	private Double horasAsignadasProyecto;
	private Long idUsuarioResponsable;
	
	public ProyectoDTO(){}
	
	public ProyectoDTO(Proyecto proyecto) {
		this.id = proyecto.getId();
		this.nombre = proyecto.getNombre();
		this.idUsuarioResponsable = proyecto.getIdUsuarioResponsable();
		this.horasAsignadasProyecto = proyecto.getHorasAsignadasProyecto();
	}
	
	
	public Long getIdUsuarioResponsable() {
		return idUsuarioResponsable;
	}

	public void setIdUsuarioResponsable(Long idUsuarioResponsable) {
		this.idUsuarioResponsable = idUsuarioResponsable;
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
