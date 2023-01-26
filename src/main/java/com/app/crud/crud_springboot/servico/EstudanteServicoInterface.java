package com.app.crud.crud_springboot.servico;

import java.util.List;

import com.app.crud.crud_springboot.entidade.Estudante;

public interface EstudanteServicoInterface {
    
    public List<Estudante> listarTodosOsEstudantes();

    public Estudante guardarEstudante(Estudante estudante);

    public Estudante obterEstudantePorId(Long id);

    public Estudante atualizarEstudante(Estudante estudante);

    public void deletarEstudante(Long id);

}