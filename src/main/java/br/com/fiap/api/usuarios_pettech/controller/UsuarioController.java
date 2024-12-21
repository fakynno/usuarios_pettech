package br.com.fiap.api.usuarios_pettech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.usuarios_pettech.dto.UsuarioDto;
import br.com.fiap.api.usuarios_pettech.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>> findAll(
        @PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable) {

            Page<UsuarioDto> usuariosDto = service.findAll(pageable);            
            return ResponseEntity.ok(usuariosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        UsuarioDto usuarioDto = service.findById(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> save(@Valid @RequestBody UsuarioDto dto) {
        UsuarioDto savedUsuarioDto = service.save(dto);
        return new ResponseEntity<>(savedUsuarioDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        UsuarioDto updatedUsuarioDto = service.update(id, dto);
        return ResponseEntity.ok(updatedUsuarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
