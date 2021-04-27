package edu.curso.java.ProyectoTB.TrackBug.bo;

import java.util.*;

import javax.persistence.*;
import javax.print.attribute.HashAttributeSet;


public class Tarea {

	private Long id;
	private String nombre;
	private Double horasAsignadas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Proyecto proyecto;
	
	@OneToOne
	private TipoDeTarea tipoDeTarea;
	
	@OneToOne
	private EstadoDeTarea estado;
	
	@ManyToMany
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public TipoDeTarea getTipoDeTarea() {
		return tipoDeTarea;
	}

	public void setTipoDeTarea(TipoDeTarea tipoDeTarea) {
		this.tipoDeTarea = tipoDeTarea;
	}

	public EstadoDeTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeTarea estado) {
		this.estado = estado;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
}
