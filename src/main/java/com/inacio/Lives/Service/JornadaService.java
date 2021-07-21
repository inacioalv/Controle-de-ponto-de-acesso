package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.JornadaTrabalho;
import com.inacio.Lives.Repository.JornadaTrabalhoRepository;


@Service
public class JornadaService {
	
	private final JornadaTrabalhoRepository jornadaRepository;

	public JornadaService(JornadaTrabalhoRepository jornadaRepository) {
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
