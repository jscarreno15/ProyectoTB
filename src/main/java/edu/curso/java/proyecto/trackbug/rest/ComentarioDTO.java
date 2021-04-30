package edu.curso.java.proyecto.trackbug.rest;

import java.util.Date;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public class ComentarioDTO {
	
	private Long id;
	private String nombre;
	private Date fecha;
	private String texto;
	
	public ComentarioDTO() {}
	
	public ComentarioDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.nombre =  comentario.getNombre();
		this.fecha = comentario.getFecha();
		this.texto = comentario.getTexto();
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
