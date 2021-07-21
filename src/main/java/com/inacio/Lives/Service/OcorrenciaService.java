package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.inacio.Lives.Model.Ocorrencia;
import com.inacio.Lives.Repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {
	
	private final OcorrenciaRepository ocorrenciaRepository;

	public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
		super();
		this.ocorrenciaRepository = ocorrenciaRepository;
	}
	
	public List<Ocorrencia> Lista(){
		return ocorrenciaRepository.findAll();
	}
	
	public Ocorrencia Busca(Long id) {
		Optional<Ocorrencia> opt = ocorrenciaRepository.findById(id);
		return opt.orElse(null);
	}
	
	public Ocorrencia Salvar( Ocorrencia obj) {
		return ocorrenciaRepository.save(obj);
		}
	
	public Ocorrencia Update(Ocorrencia obj) {
		return ocorrenciaRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		ocorrenciaRepository.deleteById(id);
	}


}
