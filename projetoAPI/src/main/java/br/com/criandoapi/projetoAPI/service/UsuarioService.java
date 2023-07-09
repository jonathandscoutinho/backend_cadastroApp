package br.com.criandoapi.projetoAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.criandoapi.projetoAPI.model.Usuario;
import br.com.criandoapi.projetoAPI.repository.IUsuario;

@Service
public class UsuarioService {
	//instanciação do CRUD Repository
	private IUsuario repository;
	
	//Construtor do objeto repository acima
	public  UsuarioService(IUsuario repository) {
		this.repository = repository;
	}

	//GET
	public List<Usuario> listarUsuario(){
		List<Usuario> Lista = repository.findAll();
		return Lista;
	}
	
	//POST
	public Usuario criarUsuario(Usuario usuario) {
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	//PUT
	public Usuario  editarUsuario(Usuario usuario) {
	Usuario usuarioNovo = repository.save(usuario);
	return usuarioNovo;
	}
	
	//DELETE
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
}
