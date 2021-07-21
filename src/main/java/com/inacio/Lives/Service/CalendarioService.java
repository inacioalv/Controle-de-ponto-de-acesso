package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.Calendario;
import com.inacio.Lives.Repository.CalendarioRepository;

@Service
public class CalendarioService {
	
	private final CalendarioRepository calendarioRepository;

	public CalendarioService(CalendarioRepository calendarioRepository) {
		super();
		this.calendarioRepository = calendarioRepository;
	}
	

	public List<Calendario> Lista(){
		return calendarioRepository.findAll();
	}
	
	public Calendario Busca(Long id) {
		Optional<Calendario> opt = calendarioRepository.findById(id);
		return opt.orElse(null);
	}
	
	public Calendario Salvar( Calendario obj) {
		return calendarioRepository.save(obj);
		}
	
	public Calendario Update(Calendario obj) {
		return calendarioRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		calendarioRepository.deleteById(id);
	}

}
