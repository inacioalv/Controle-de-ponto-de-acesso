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

import com.inacio.Lives.Model.NivelAcesso;
import com.inacio.Lives.Service.NivelAcessoService;

@RestController
@RequestMapping("/api/v1/nivelAcesso")
public class NivelAcessoController {

	private NivelAcessoService acessoService;

	public NivelAcessoController(NivelAcessoService acessoService) {
		super();
		this.acessoService = acessoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<NivelAcesso> Lista(){
		return acessoService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public NivelAcesso Busca(@PathVariable Long id) {
		return acessoService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody NivelAcesso NivelAcesso){
		NivelAcesso obj = acessoService.Salvar(NivelAcesso);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody NivelAcesso obj, @PathVariable Long id){
		obj.setId(id);
		acessoService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		acessoService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
}
