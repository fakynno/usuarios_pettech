package br.com.fiap.api.usuarios_pettech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.api.usuarios_pettech.dto.UsuarioDto;

public interface UsuarioService {

    Page<UsuarioDto> findAll(Pageable pageable);    

    UsuarioDto findById(Long id);

    UsuarioDto save(UsuarioDto dto);

    UsuarioDto update(Long id, UsuarioDto dto);

    void delete(Long id);

}
