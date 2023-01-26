package com.app.crud.crud_springboot.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.crud.crud_springboot.entidade.Estudante;

@Repository
public interface EstudanteRepositorio extends JpaRepository<Estudante, Long> {
    
}