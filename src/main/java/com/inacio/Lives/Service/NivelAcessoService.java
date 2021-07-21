package com.inacio.Lives.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.inacio.Lives.Model.NivelAcesso;
import com.inacio.Lives.Repository.NivelAcessoRepository;

@Service
public class NivelAcessoService {
	
	private final NivelAcessoRepository acessoRepository;

	public NivelAcessoService(NivelAcessoRepository acessoRepository) {
		super();
		this.acessoRepository = acessoRepository;
	}
	
	public List<NivelAcesso> Lista(){
		return acessoRepository.findAll();
	}
	
	public NivelAcesso Busca(Long id) {
		Optional<NivelAcesso> opt = acessoRepository.findById(id);
		return opt.orElse(null);
	}
	
	public NivelAcesso Salvar( NivelAcesso obj) {
		return acessoRepository.save(obj);
		}
	
	public NivelAcesso Update(NivelAcesso obj) {
		return acessoRepository.save(obj);
	}
	
	public void Deletar(Long id) {
		acessoRepository.deleteById(id);
	}

}
