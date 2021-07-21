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

import com.inacio.Lives.Model.Localidade;
import com.inacio.Lives.Service.LocalidadeService;

@RestController
@RequestMapping("/api/v1/localidade")
public class LocalidadeController {
	
	private LocalidadeService localidadeService;

	public LocalidadeController(LocalidadeService localidadeService) {
		super();
		this.localidadeService = localidadeService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Localidade> Lista(){
		return localidadeService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Localidade Busca(@PathVariable Long id) {
		return localidadeService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody Localidade Localidade){
		Localidade obj = localidadeService.Salvar(Localidade);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody Localidade obj, @PathVariable Long id){
		obj.setId(id);
		localidadeService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		localidadeService.Deletar(id);
		return ResponseEntity.noContent().build();
	}

}
