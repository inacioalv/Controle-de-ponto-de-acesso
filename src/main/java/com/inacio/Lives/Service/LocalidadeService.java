package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.Localidade;
import com.inacio.Lives.Repository.LocalidadeRepository;

@Service
public class LocalidadeService {
	
	private final LocalidadeRepository localidadeRepository;

	public LocalidadeService(LocalidadeRepository localidadeRepository) {
		super();
		this.localidadeRepository = localidadeRepository;
	}
	
	public List<Localidade> Lista(){
		return localidadeRepository.findAll();
	}
	
	public Localidade Busca(Long id) {
		Optional<Localidade> opt = localidadeRepository.findById(id);
		return opt.orElse(null);
	}
	
	public Localidade Salvar( Localidade obj) {
		return localidadeRepository.save(obj);
		}
	
	public Localidade Update(Localidade obj) {
		return localidadeRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		localidadeRepository.deleteById(id);
	}
	

}
