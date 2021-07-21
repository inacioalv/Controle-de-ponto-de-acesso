package com.inacioalves.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.inacioalves.live.model.JornadaTrabalho;
import com.inacioalves.live.repository.JornadaRepository;

@Service
public class JornadaService {
	
	private final JornadaRepository jornadaRepository;
	
	public JornadaService(JornadaRepository jornadaRepository) {
		super();
		this.jornadaRepository = jornadaRepository;
	}

	public List<JornadaTrabalho> Lista(){
		return jornadaRepository.findAll();
	}
	
	public JornadaTrabalho Busca(Long id) {
		Optional<JornadaTrabalho> opt = jornadaRepository.findById(id);
		return opt.orElse(null);
	}
	
	public JornadaTrabalho Salvar( JornadaTrabalho obj) {
		return jornadaRepository.save(obj);
		}
	
	public JornadaTrabalho Update(JornadaTrabalho obj) {
		return jornadaRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		jornadaRepository.deleteById(id);
	}
	

	

}
