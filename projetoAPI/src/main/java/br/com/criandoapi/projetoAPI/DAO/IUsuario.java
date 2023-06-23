package br.com.criandoapi.projetoAPI.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoapi.projetoAPI.model.Usuario;


public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
}
