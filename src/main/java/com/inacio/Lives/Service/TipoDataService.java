package com.inacio.Lives.Service;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.TipoData;
import com.inacio.Lives.Repository.TipoDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {
	
	private final TipoDataRepository dataRepository;
	
	public TipoDataService(TipoDataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}

	public List<TipoData> Lista(){
		return dataRepository.findAll();
	}
	
	public TipoData Busca(Long id) {
		Optional<TipoData> opt = dataRepository.findById(id);
		return opt.orElse(null);
	}
	
	public TipoData Salvar( TipoData obj) {
		return dataRepository.save(obj);
		}
	
	public TipoData Update(TipoData obj) {
		return dataRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		dataRepository.deleteById(id);
	}
	

}
