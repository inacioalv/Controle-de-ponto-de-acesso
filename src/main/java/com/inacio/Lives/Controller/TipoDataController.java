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

import com.inacio.Lives.Model.TipoData;
import com.inacio.Lives.Service.TipoDataService;


@RestController
@RequestMapping("/api/v1/tipodata")
public class TipoDataController {
	
	private TipoDataService dataService;


	public TipoDataController(TipoDataService dataService) {
		super();
		this.dataService = dataService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TipoData> Lista(){
		return dataService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public TipoData Busca(@PathVariable Long id) {
		return dataService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody TipoData TipoData){
		TipoData obj = dataService.Salvar(TipoData);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody TipoData obj, @PathVariable Long id){
		obj.setId(id);
		dataService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		dataService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
