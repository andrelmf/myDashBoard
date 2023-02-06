package com.app.crud.crud_springboot.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome",nullable = false, length = 50)
    private String nome;

    @Column(name = "apelido", nullable = false, length = 50)
    private String apelido;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email; 


    public Usuario(){
        
    }


    public Usuario (Long id, String nome, String apelido, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
    }

    public Usuario (String nome, String apelido, String email) {
        super();
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
    }

// Getters and Setters
    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

// toString
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", email=" + email + "]";
    }

    

}