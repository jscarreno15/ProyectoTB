package edu.curso.java.ProyectoTB.TrackBug.bo;


import java.util.*;

import javax.persistence.OneToOne;

public class TipoDeTarea {

	
	@OneToOne(mappedBy = "tipoDeTarea")
	private Tarea tarea;
	private Long id;
	private String nombre;
	
	public TipoDeTarea(){}
	
	public TipoDeTarea(String nombre){
		this.nombre = nombre;
	}
	
	List<TipoDeTarea> tiposDeTarea = new ArrayList<TipoDeTarea>();
}
