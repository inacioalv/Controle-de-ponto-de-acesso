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

import com.inacio.Lives.Model.CategoriaUsuario;
import com.inacio.Lives.Service.CategoriaUsuarioService;

@RestController
@RequestMapping("/api/v1/categoriauser")
public class CategoriaUsuarioController {
	
	private CategoriaUsuarioService categoriaUsuarioService;

	public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
		super();
		this.categoriaUsuarioService = categoriaUsuarioService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoriaUsuario> Lista(){
		return categoriaUsuarioService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public CategoriaUsuario Busca(@PathVariable Long id) {
		return categoriaUsuarioService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody CategoriaUsuario CategoriaUsuario){
		CategoriaUsuario obj = categoriaUsuarioService.Salvar(CategoriaUsuario);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody CategoriaUsuario obj, @PathVariable Long id){
		obj.setId(id);
		categoriaUsuarioService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		categoriaUsuarioService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
