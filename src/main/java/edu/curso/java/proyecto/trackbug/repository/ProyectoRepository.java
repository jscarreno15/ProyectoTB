package edu.curso.java.proyecto.trackbug.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public interface ProyectoRepository extends CrudRepository <Proyecto , Long>{

	@Query(value = "from Proyecto p  where p.nombre like : nombre")
	public List<Proyecto> buscadorDeProyectos(@Param("nombre") String nombre);
	
}
