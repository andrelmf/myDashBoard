package com.app.crud.crud_springboot.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.crud_springboot.entidade.Estudante;
import com.app.crud.crud_springboot.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServicoImpl implements EstudanteServicoInterface {

    @Autowired
    private EstudanteRepositorio repositorio;

    @Override
    public List<Estudante> listarTodosOsEstudantes() {
        return repositorio.findAll();
    }

    @Override
    public Estudante guardarEstudante(Estudante estudante) {
        return repositorio.save(estudante);
    }

    @Override
    public Estudante obterEstudantePorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Estudante atualizarEstudante(Estudante estudante) {
        return repositorio.save(estudante);
    }

    @Override
    public void deletarEstudante(Long id) {
        repositorio.deleteById(id);
        
    }




    
}