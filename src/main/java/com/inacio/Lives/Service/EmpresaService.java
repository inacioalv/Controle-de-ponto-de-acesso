package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.Empresa;
import com.inacio.Lives.Repository.EmpresaRepository;

@Service 
public class EmpresaService {
	
	private final  EmpresaRepository empresaRepository;

	public EmpresaService(EmpresaRepository empresaRepository) {
		super();
		this.empresaRepository = empresaRepository;
	}
	
	
	public List<Empresa> Lista(){
		return empresaRepository.findAll();
	}
	
	public Empresa Busca(Long id) {
		Optional<Empresa> opt = empresaRepository.findById(id);
		return opt.orElse(null);
	}
	
	public Empresa Salvar( Empresa obj) {
		return empresaRepository.save(obj);
		}
	
	public Empresa Update(Empresa obj) {
		return empresaRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		empresaRepository.deleteById(id);
	}
	
}
