package com.app.crud.crud_springboot.servico;

import java.util.List;

import com.app.crud.crud_springboot.entidade.Usuario;

public interface UsuarioServicoInterface {
    
    public List<Usuario> listarTodosOsUsuarios();

    public Usuario guardarUsuario(Usuario usuario);

    public Usuario obterUsuarioPorId(Long id);

    public Usuario atualizarUsuario(Usuario usuario);

    public void deletarUsuario(Long id);

}