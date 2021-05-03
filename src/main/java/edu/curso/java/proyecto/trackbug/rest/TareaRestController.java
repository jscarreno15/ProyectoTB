package edu.curso.java.proyecto.trackbug.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.Proyecto;
import edu.curso.java.proyecto.trackbug.bo.Tarea;
import edu.curso.java.proyecto.trackbug.service.TareaService;
import edu.curso.java.proyecto.trackbug.service.UsuarioService;

@RestController
@RequestMapping("/tareas")
public class TareaRestController {
	
	@Autowired
	private TareaService tareaService;
	
	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping
	public ResponseEntity <List<TareaDTO>> listarTareas()	{
		List<Tarea> tareas = tareaService.listarTareas();
		List<TareaDTO> tareaDTO = new ArrayList<TareaDTO>();
		for(Tarea t : tareas) {
			tareaDTO.add(new TareaDTO(t));
		}
		return ResponseEntity.ok(tareaDTO);
	}
	
	@GetMapping(path = "/{id}")//manejar excepcion si no encuentra el proyecto
	public ResponseEntity <TareaDTO> listaTareasPorId(@PathVariable Long id){
			try {
			Tarea tarea = tareaService.buscarTareasPorId(id);
			TareaDTO tareaDTO = new TareaDTO(tarea);
			return ResponseEntity.ok(tareaDTO);
			}catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
			}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity borrarTarea(@PathVariable Long id) {
		tareaService.borrarTarea(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping(path = "/buscador")
	public ResponseEntity <List<TareaDTO>> buscarTareasPorNombre(@RequestParam String nombre){
		List<Tarea> tareas = tareaService.buscadorDeTareas(nombre);
		List<TareaDTO>tareaDTO = new ArrayList<TareaDTO>();
		for(Tarea t : tareas) {
			tareaDTO.add(new TareaDTO(t));
		}
		return ResponseEntity.ok(tareaDTO);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity actualizarTarea(@PathVariable Long id, @RequestBody TareaDTO tareaDTO) {
		try {
		Tarea tarea= tareaService.buscarTareasPorId(id);
		tarea.setId(tareaDTO.getId());
		tarea.setHorasAsignadas(tareaDTO.getHorasAsignadas());
		tarea.setIdEstado(tareaDTO.getIdEstado());
		tarea.setIdTipoTarea(tareaDTO.getIdTipoTarea());
		tareaService.actualizarTarea(tarea);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	
	@PutMapping(path = "/{id}/asignarusuario/{idUsuario}")
	public ResponseEntity <Long> asignarUsuario(@PathVariable Long id ,@PathVariable Long idUsuario){
		tareaService.asignarUsuario(id, idUsuario);
		return  ResponseEntity.ok(id);
	}
	
	
	
	

}
