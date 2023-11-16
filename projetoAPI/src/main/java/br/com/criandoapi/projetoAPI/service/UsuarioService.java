package br.com.criandoapi.projetoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projetoAPI.model.Usuario;
import br.com.criandoapi.projetoAPI.repository.IUsuario;

@Service
public class UsuarioService {
	//instanciação do CRUD Repository
	private IUsuario repository;
	private PasswordEncoder passwordEncoder;
	
	//Construtor do objeto repository acima
	public  UsuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	//GET
	public List<Usuario> listarUsuario(){
		List<Usuario> Lista = repository.findAll();
		return Lista;
	}
	
	//POST
	public Usuario criarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	//PUT
	public Usuario  editarUsuario(Usuario usuario) {
	String encoder = this.passwordEncoder.encode(usuario.getSenha());
	usuario.setSenha(encoder);
	Usuario usuarioNovo = repository.save(usuario);
	return usuarioNovo;
	}
	
	//DELETE
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
	    Optional<Usuario> optionalUsuario = repository.findById(usuario.getId());

	    if (optionalUsuario.isPresent()) {
	        String senha = optionalUsuario.get().getSenha();
	        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
	        return valid;
	    } else {
	        return false;
	    }
	}
}
