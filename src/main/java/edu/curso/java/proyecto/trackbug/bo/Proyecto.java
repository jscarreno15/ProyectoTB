package edu.curso.java.proyecto.trackbug.bo;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "PROYECTOS")
public class Proyecto {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Double horasAsignadasProyecto;
	private Long idUsuarioResponsable;
	
	@OneToMany(mappedBy = "proyecto")
	private Set<Tarea> tareas = new HashSet<Tarea>();
	
	public void agregarTarea(Tarea tarea) {
		tareas.add(tarea);
	}
	
	@ManyToOne
	private Usuario usuarioResponsable;
	
	@ManyToMany
	private Set<Usuario> usuarios = new HashSet<Usuario>();
		

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

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
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
			Proyecto other = (Proyecto) obj;
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


	public Set<Tarea> getTareas() {
		return tareas;
	}


	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}


	public Usuario getUsuarioResponsable() {
		return usuarioResponsable;
	}


	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}


	
	
}
