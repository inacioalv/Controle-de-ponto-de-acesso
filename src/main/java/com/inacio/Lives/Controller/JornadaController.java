package com.inacio.Lives.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inacio.Lives.Model.JornadaTrabalho;
import com.inacio.Lives.Service.JornadaService;

import java.net.URI;



@RestController
@RequestMapping("/api/v1/jornada")
public class JornadaController {
	
	private JornadaService jornadaService;

	public JornadaController(JornadaService jornadaService) {
		super();
		this.jornadaService = jornadaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<JornadaTrabalho> Lista(){
		return jornadaService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public JornadaTrabalho Busca(@PathVariable Long id) {
		return jornadaService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody JornadaTrabalho jornadaTrabalho){
		JornadaTrabalho obj = jornadaService.Salvar(jornadaTrabalho);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody JornadaTrabalho obj, @PathVariable Long id){
		obj.setId(id);
		jornadaService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		jornadaService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
