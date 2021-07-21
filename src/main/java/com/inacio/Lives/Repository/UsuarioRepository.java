package com.inacio.Lives.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inacio.Lives.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
