package com.firstcode.code.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.firstcode.code.models.UserModel;
import com.firstcode.code.repositorios.IUserRepositoriy;

@Service
public class UserService {
    // inyeccion de dependencias
    @Autowired
    IUserRepositoriy userRepositoriy;

    public ArrayList<UserModel> getUsers(){
        // userRepository es un metodo de jpaRepository
        return (ArrayList<UserModel>) userRepositoriy.findAll();
    }

    public UserModel saveUser(UserModel user){
        // estos save metodo es un metodo de JPA creo
        return userRepositoriy.save(user);
    }
    
    public Optional<UserModel> getByid(Long id){
        return userRepositoriy.findById(id);
    }
    // esto parte es como ccuando ResultSet es parecido que traimos los datos y le setiabamos
    public UserModel updateByID(UserModel request, Long id ){
        UserModel userModel = userRepositoriy.findById(id).get();
        userModel.setFirstname(request.getFirstname());
        userModel.setLastName(request.getLastName());
        userModel.setEmail(request.getEmail());
        userRepositoriy.save(userModel);
        return userModel;
        }

    public Boolean deleteUser(Long id){
        try {
            userRepositoriy.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
