package com.app.crud.crud_springboot.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.crud_springboot.entidade.Usuario;
import com.app.crud.crud_springboot.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicoImpl implements UsuarioServicoInterface {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<Usuario> listarTodosOsUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public Usuario obterUsuarioPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        repositorio.deleteById(id);
        
    }




    
}