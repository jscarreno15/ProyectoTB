package edu.curso.java.proyecto.trackbug.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.proyecto.trackbug.bo.Comentario;
import edu.curso.java.proyecto.trackbug.bo.Usuario;
import edu.curso.java.proyecto.trackbug.service.TareaService;
import edu.curso.java.proyecto.trackbug.service.UsuarioService;





@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ComentarioService comentarioService;


	
	
	@GetMapping
	public ResponseEntity listarUsuarios() {
		List<Usuario> usuarios= usuarioService.listarUsuarios();
		List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();
		for(Usuario u : usuarios){
			usuarioDTO.add(new UsuarioDTO(u));
		}
		return ResponseEntity.ok(usuarioDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> crearUsuario(@Validated @RequestBody UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuarioService.crearUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity listarUsuariosPorId(@PathVariable Long id) {
		Usuario usuario= usuarioService.listarUsuarioPorId(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return ResponseEntity.ok(usuarioDTO);
	}
	
	@PostMapping(path = "/{idUsuario}/cargarcomentario")
	public ResponseEntity <Comentario>listarComentarios(@PathVariable Long idUsuario , @Validated @RequestBody ComentarioDTO comentarioDTO) {
		Comentario comentario = new Comentario();
		comentario.setId(comentarioDTO.getId());
		comentario.setNombre(comentarioDTO.getNombre());
		comentario.setFecha(comentarioDTO.getFecha());
		comentario.setTexto(comentarioDTO.getTexto());
		comentario.setCreadoPor(usuarioService.listarUsuarioPorId(idUsuario));
		comentarioService.guardarComentario(comentario);
		return ResponseEntity.ok(comentario);
	}
	
	@DeleteMapping(path = "/comentario/{id}")
	public ResponseEntity borrarProyecto(@PathVariable Long id) {
		comentarioService.borrarComentario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
