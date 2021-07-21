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
import com.inacio.Lives.Model.Empresa;
import com.inacio.Lives.Service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
	
	private final EmpresaService empresaService;

	public EmpresaController(EmpresaService empresaService) {
		super();
		this.empresaService = empresaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Empresa> Lista(){
		return empresaService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Empresa Busca(@PathVariable Long id) {
		return empresaService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody Empresa Empresa){
		Empresa obj = empresaService.Salvar(Empresa);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody Empresa obj, @PathVariable Long id){
		obj.setId(id);
		empresaService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		empresaService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
