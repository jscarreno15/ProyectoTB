package edu.curso.java.ProyectoTB.TrackBug.bo;

import java.util.*;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Usuario {

	private String comentario;
	private String fecha;
	
	@OneToMany
	private Set<Usuario> usuariosAsignados = new HashSet<Usuario>();
	
	@OneToOne(mappedBy = "usuarioResponsable")
	private Proyecto proyecto;
	
	@ManyToMany(mappedBy = "usuarios")
	private Set<Tarea> tareas = new HashSet<Tarea>();
	
	public void CargarComentario() {
		
	}
}
