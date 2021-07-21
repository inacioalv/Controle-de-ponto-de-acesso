package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.CategoriaUsuario;
import com.inacio.Lives.Repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {
	
	private final CategoriaUsuarioRepository categoriaUsuarioRepository;

	public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
		super();
		this.categoriaUsuarioRepository = categoriaUsuarioRepository;
	}
	
	public List<CategoriaUsuario> Lista(){
		return categoriaUsuarioRepository.findAll();
	}
	
	public CategoriaUsuario Busca(Long id) {
		Optional<CategoriaUsuario> opt = categoriaUsuarioRepository.findById(id);
		return opt.orElse(null);
	}
	
	public CategoriaUsuario Salvar( CategoriaUsuario obj) {
		return categoriaUsuarioRepository.save(obj);
		}
	
	public CategoriaUsuario Update(CategoriaUsuario obj) {
		return categoriaUsuarioRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		categoriaUsuarioRepository.deleteById(id);
	}
	

}
