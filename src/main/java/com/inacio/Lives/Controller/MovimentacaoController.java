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

import com.inacio.Lives.Model.Movimentacao;
import com.inacio.Lives.Model.Movimentacao.MovimentacaoId;
import com.inacio.Lives.Service.MovimentacaoService;

@RestController
@RequestMapping("/api/v1/movimentacao")
public class MovimentacaoController {
	
	private MovimentacaoService movimentacaoService;

	public MovimentacaoController(MovimentacaoService movimentacaoService) {
		super();
		this.movimentacaoService = movimentacaoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movimentacao> Lista(){
		return movimentacaoService.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Movimentacao Busca(@PathVariable Long id) {
		return movimentacaoService.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody Movimentacao Movimentacao){
		Movimentacao obj = movimentacaoService.Salvar(Movimentacao);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody Movimentacao obj, @PathVariable MovimentacaoId id){
		obj.setId(id);
		movimentacaoService.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		movimentacaoService.Deletar(id);
		return ResponseEntity.noContent().build();
	}


}
