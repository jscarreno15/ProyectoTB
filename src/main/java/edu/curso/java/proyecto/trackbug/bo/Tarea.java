package edu.curso.java.proyecto.trackbug.bo;

import java.util.*;

import javax.persistence.*;
import javax.print.attribute.HashAttributeSet;


@Entity
@Table(name = "TAREAS")
public class Tarea {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Long idEstado;
	private Long idTipoTarea;

	private Double horasAsignadas;
	
	@ManyToOne
	private Proyecto proyecto;
	
	@ManyToOne
	private TipoDeTarea tipoDeTarea;
	
	@ManyToOne
	private EstadoDeTarea estado;
	
	@ManyToMany
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	@OneToMany
	@JoinColumn(name = "TAREA_ID")
	private Set<Comentario> comentarios = new HashSet<Comentario>();
	
	public void agregarUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		comentarios = comentarios;
	}


	public Double getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(Double horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}

	