package com.ltpo.aplicacao.services;

import com.ltpo.aplicacao.models.Usuario;
import com.ltpo.aplicacao.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        // Criptografar senha em aplicação real
        return usuarioRepository.save(usuario);
    }

    public List listarTodos() {
        return usuarioRepository.findAll();
    }
}
