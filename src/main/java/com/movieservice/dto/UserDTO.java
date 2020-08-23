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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<RentDTO> rents;

    public List<RentDTO> getRents() {
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
        List<RentDTO> rentDTOS = user.getRents().stream().
                map(rent ->RentDTO.get(rent)).collect(Collectors.toList());
        this.rents = rentDTOS;
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
