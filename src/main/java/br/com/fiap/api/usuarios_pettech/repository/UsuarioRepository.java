package br.com.fiap.api.usuarios_pettech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.api.usuarios_pettech.dto.UsuarioDto;
import br.com.fiap.api.usuarios_pettech.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    Optional<UsuarioDto> findByEmail(String email);

}
