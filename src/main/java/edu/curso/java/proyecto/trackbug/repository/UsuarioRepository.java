package edu.curso.java.proyecto.trackbug.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.bo.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario, Long>{

	//@Query(value = "from Usuario u  where u.nombre like : nombre")
	//public List<Usuario> buscadorDeUsuario(@Param("nombre") String nombre);
	
//	@Query(value = "from Usuario u where u.proyecto.id = :idProyecto")
	//public Set<Tarea> UsuariosPorProyecto(@Param("idProyecto") Long idProyecto);
}
