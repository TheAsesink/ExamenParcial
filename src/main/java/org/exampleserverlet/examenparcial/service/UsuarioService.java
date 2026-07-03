package org.exampleserverlet.examenparcial.service;

import org.exampleserverlet.examenparcial.entity.Usuario;
import org.exampleserverlet.examenparcial.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void crearAdministrador() {
        if (usuarioRepository.findByUsername("admin").isPresent()) {
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setUsername("admin");
        usuario.setPasswordHash(passwordEncoder.encode("Admin*2026"));
        usuario.setRol("ADMIN");

        usuarioRepository.save(usuario);
    }
}