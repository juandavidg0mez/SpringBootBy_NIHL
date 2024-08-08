package com.firstcode.code.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Cada uno de los campos que se agregaen va ha ser una columna en la base de datos.
@Entity
// Se agrega la anotacion table dado para que no adquiera op herede el nombre de la clase En este caso "USerModel" por lo tanto se le coloca este nuevo nombre. 
@Table(name = "user")
public class UserModel {
    // Como son Abstractas se crean getters and setters dado que cada nuevo ususario manejara sus datos de una forma diferente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String LastName;

    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

}
