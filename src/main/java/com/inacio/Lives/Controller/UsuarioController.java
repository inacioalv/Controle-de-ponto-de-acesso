package com.inacio.Lives.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inacio.Lives.Model.Usuario;
import com.inacio.Lives.Service.UsuarioService;

@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {
	
	private UsuarioService serviceUsuarioService;

	public UsuarioController(UsuarioService serviceUsuarioService) {
		super();
		this.serviceUsuarioService = serviceUsuarioService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> Lista(){
		return serviceUsuarioService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Usuario Busca(@PathVariable Long id) {
		return serviceUsuarioService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody Usuario Usuario){
		Usuario obj = serviceUsuarioService.Salvar(Usuario);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody Usuario obj, @PathVariable Long id){
		obj.setId(id);
		serviceUsuarioService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		serviceUsuarioService.Deletar(id);
		return ResponseEntity.noContent().build();
	}

}
