package br.com.fiap.api.usuarios_pettech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.api.usuarios_pettech.dto.UsuarioDto;
import br.com.fiap.api.usuarios_pettech.entities.UsuarioEntity;
import br.com.fiap.api.usuarios_pettech.exceptions.ControllerNotFoundException;
import br.com.fiap.api.usuarios_pettech.repository.UsuarioRepository;
import br.com.fiap.api.usuarios_pettech.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {

        Page<UsuarioEntity> usuarios = repository.findAll(pageable);
        return usuarios.map(this::toDto);        
    }

    
    @Override
    public UsuarioDto findById(Long id) {
        
        UsuarioEntity usuario = repository.findById(id)
            .orElseThrow(() -> 
                    new ControllerNotFoundException("Usuario nao encontrado"));
        
        return toDto(usuario);
    }
    
    @Override
    public UsuarioDto save(UsuarioDto dto) {
        
        UsuarioEntity usuario = toEntity(dto);
        repository.save(usuario);

        return toDto(usuario);
    }
    
    @Override
    public UsuarioDto update(Long id, UsuarioDto dto) {
        
        try {
            UsuarioEntity usuarioExistente = repository.getReferenceById(id);
            
            usuarioExistente.setNome(dto.nome());
            usuarioExistente.setEmail(dto.email());
            usuarioExistente.setCpf(dto.cpf());
            usuarioExistente.setDataNascimento(dto.dataNascimento());
            repository.save(usuarioExistente);
            
            return toDto(usuarioExistente);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Usuario nao encontrado");
        }
    }
    
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }    
    
    public UsuarioDto toDto(UsuarioEntity usuarioEntity) {        
        return new UsuarioDto(
            usuarioEntity.getId(), 
            usuarioEntity.getNome(), 
            usuarioEntity.getEmail(), 
            usuarioEntity.getCpf(), 
            usuarioEntity.getDataNascimento());        
    }
    
    public UsuarioEntity toEntity(UsuarioDto dto) {        
        return new UsuarioEntity(
            dto.id(), 
            dto.nome(), 
            dto.email(), 
            dto.cpf(), 
            dto.dataNascimento()
        );
    }
}
