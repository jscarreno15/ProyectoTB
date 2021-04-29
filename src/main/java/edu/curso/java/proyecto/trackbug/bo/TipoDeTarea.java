package edu.curso.java.proyecto.trackbug.bo;


import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_DE_TAREAS")
public class TipoDeTarea {

	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
	
	