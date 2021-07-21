package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inacio.Lives.Model.Usuario;
import com.inacio.Lives.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Usuario> Lista(){
		return repository.findAll();
	}
	
	public Usuario Busca(Long id) {
		Optional<Usuario> opt = repository.findById(id);
		return opt.orElse(null);
	}
	
	public Usuario Salvar( Usuario obj) {
		return repository.save(obj);
		}
	
	public Usuario Update(Usuario obj) {
		return repository.save(obj);
	}
	
	public void Deletar(Long id) {
		repository.deleteById(id);
	}
	

}
