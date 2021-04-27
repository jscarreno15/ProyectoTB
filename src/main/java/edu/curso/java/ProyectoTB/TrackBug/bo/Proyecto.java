package edu.curso.java.ProyectoTB.TrackBug.bo;

import java.util.*;
import javax.persistence.*;

public class Proyecto {

	private Long id;
	private String nombre;
	
	@OneToMany
	private Set<Tarea> tareas = new HashSet<Tarea>();
	
	
	@OneToOne
	private Usuario usuarioResponsable;
	
	//calcula las horas del proyecto
	public Double cantidadHorasAsignadas() {
		Double horasAsinadas = 0.0;
		for (Tarea e : tareas) {
			horasAsinadas =+ e.getHorasAsignadas();
		}
		return horasAsinadas;
	}
	
}
