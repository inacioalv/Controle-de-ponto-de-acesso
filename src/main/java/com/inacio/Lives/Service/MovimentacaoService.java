package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.Movimentacao;
import com.inacio.Lives.Repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	private final MovimentacaoRepository movimentacaoRepository;

	public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
		super();
		this.movimentacaoRepository = movimentacaoRepository;
	}
	
	public List<Movimentacao> Lista(){
		return movimentacaoRepository.findAll();
	}
	
	public Movimentacao Busca(Long id) {
		Optional<Movimentacao> opt = movimentacaoRepository.findById(id);
		return opt.orElse(null);
	}
	
	public Movimentacao Salvar( Movimentacao obj) {
		return movimentacaoRepository.save(obj);
		}
	
	public Movimentacao Update(Movimentacao obj) {
		return movimentacaoRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		movimentacaoRepository.deleteById(id);
	}
	

}
