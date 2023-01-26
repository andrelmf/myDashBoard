package com.app.crud.crud_springboot.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.crud.crud_springboot.entidade.Estudante;
import com.app.crud.crud_springboot.servico.EstudanteServicoInterface;

@Controller
public class EstudanteControlador {

    @Autowired
    private EstudanteServicoInterface servico;
    // Endereço da Home page
    // @GetMapping({"/home", "/"})
    // public String goToHomePage(){
    // return "home";
    // }

    // Listar Estudante
    @GetMapping({ "/estudantes", "/" })
    public String listarEstudantes(Model modelo) {

        modelo.addAttribute("estudantes", servico.listarTodosOsEstudantes());
        return "estudantes"; // Retorna o arquivo estudantes
    }

    // Cadastrar Estudante
    @GetMapping({ "/estudantes/cadastrarEstudante" })
    public String mostrarFormularioDeRegistroEstudante(Model modelo) {
        Estudante estudante = new Estudante();
        modelo.addAttribute("estudante", estudante);
        return "cadastrarEstudante";
    }

    @PostMapping("/estudantes")
    public String guardarEstudante(@ModelAttribute("estudante") Estudante estudante) {
        // servico.guardarEstudante(estudante);

        servico.guardarEstudante(estudante);
        return "redirect:/estudantes";
    }

    // Editar Estudante
    @GetMapping("/estudantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudante", servico.obterEstudantePorId(id));
        return "editarEstudante";
    }

    @PostMapping("/estudantes/{id}")
    public String atualizarEstudante(@PathVariable Long id, @ModelAttribute("estudante") Estudante estudante,
            Model modelo) {
        Estudante estudanteExistente = servico.obterEstudantePorId(id);
        estudanteExistente.setId(id);
        estudanteExistente.setNome(estudante.getNome());
        estudanteExistente.setApelido(estudante.getApelido());
        estudanteExistente.setEmail(estudante.getEmail());

        servico.atualizarEstudante(estudanteExistente);
        return "redirect:/estudantes";
    }

    // Deletar Estudante
    @GetMapping("/estudantes/{id}")
    public String deletarEstudante(@PathVariable Long id) {
        servico.deletarEstudante(id);
        return "redirect:/estudantes";
    }

}