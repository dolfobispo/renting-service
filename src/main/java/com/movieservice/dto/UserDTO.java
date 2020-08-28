package com.movieservice.dto;

import com.movieservice.models.Rent;
import com.movieservice.models.User;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


public class UserDTO  implements Serializable {

    private Long id;
    private String email;
    private String name;
    private String cpf;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Rent> rents;

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserDTO(){

    }
    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.lastName = user.getLastName();
        this.rents = user.getRents();
    }

    public static UserDTO get(User user){
        return new UserDTO(user);
    }
    public static UserDTO getUserRentDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        return userDTO;
    }


}
