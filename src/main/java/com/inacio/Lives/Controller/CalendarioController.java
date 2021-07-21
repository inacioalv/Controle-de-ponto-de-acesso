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

import com.inacio.Lives.Model.Calendario;
import com.inacio.Lives.Service.CalendarioService;

@RestController
@RequestMapping("/api/v1/calendario")
public class CalendarioController {
	
	private CalendarioService calendarioService;

	public CalendarioController(CalendarioService calendarioService) {
		super();
		this.calendarioService = calendarioService;
	};
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Calendario> Lista(){
		return calendarioService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Calendario Busca(@PathVariable Long id) {
		return calendarioService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody Calendario Calendario){
		Calendario obj = calendarioService.Salvar(Calendario);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody Calendario obj, @PathVariable Long id){
		obj.setId(id);
		calendarioService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		calendarioService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
