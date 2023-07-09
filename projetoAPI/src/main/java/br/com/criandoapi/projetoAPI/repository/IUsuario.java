package br.com.criandoapi.projetoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoapi.projetoAPI.model.Usuario;


public interface IUsuario extends JpaRepository<Usuario, Integer>{
	
}
