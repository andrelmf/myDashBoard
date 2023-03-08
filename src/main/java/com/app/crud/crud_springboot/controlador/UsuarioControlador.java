package com.app.crud.crud_springboot.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.crud.crud_springboot.entidade.Usuario;
import com.app.crud.crud_springboot.servico.UsuarioServicoInterface;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicoInterface servico;

    // Endereço da Home page
    @GetMapping({"/", "/home"})
    public String goToHomePage(){
        return "home";
    }
    
    // Sobre Mim
    @GetMapping({"/home/sobreMim"})
    public String goToSobreMim(){
        return "sobreMim";
    }


    // CRUD - Usuários
    // Listar Usuario
    @GetMapping({ "/home/usuarios", "/usuarios"})
    public String listarUsuarios(@PageableDefault(page = 2, size = 2, direction = Sort.Direction.ASC) Model modelo) {
        modelo.addAttribute("usuarios", servico.listarTodosOsUsuarios());
        return "usuarios"; // Retorna o arquivo usuarios
    }

    // Cadastrar Usuario
    @GetMapping({ "/home/usuarios/cadastrarUsuario" })
    public String mostrarFormularioDeRegistroUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "cadastrarUsuario";
    }

    @PostMapping("/home/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        // servico.guardarUsuario(usuario);

        servico.guardarUsuario(usuario);
        return "redirect:/home/usuarios";
    }

    // Editar Usuario
    @GetMapping("/home/usuarios/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("usuario", servico.obterUsuarioPorId(id));
        return "editarUsuario";
    }

    @PostMapping("/home/usuarios/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario,
            Model modelo) {
        Usuario usuarioExistente = servico.obterUsuarioPorId(id);
        usuarioExistente.setId(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setApelido(usuario.getApelido());
        usuarioExistente.setEmail(usuario.getEmail());

        servico.atualizarUsuario(usuarioExistente);
        return "redirect:/home/usuarios";
    }

    // Deletar Usuario
    @GetMapping("/home/usuarios/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        servico.deletarUsuario(id);
        return "redirect:/home/usuarios";
    }

}