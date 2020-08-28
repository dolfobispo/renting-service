package com.movieservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    @Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres")
    @NotBlank(message = "O nome deve ser preenchido")
    private String name;
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
    private String cpf;
    @Email
    @NotBlank(message = "O e-mail deve ser preenchido")
    private String email;
    @NotBlank(message = "A senha deve ser preenchida")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Rent> rents = new ArrayList<>();

    public List<Rent> getRents() {
        return rents;
    }

    public User(Long id, String name, String lastName, String cpf, String email, String password) {
        this.name = name;
        this.id = id;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
