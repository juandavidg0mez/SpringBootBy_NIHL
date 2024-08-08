package com.firstcode.code.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstcode.code.models.UserModel;
import com.firstcode.code.servicios.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
// se define la ruta
@RequestMapping("/user")
public class UserController {

    // aca se definen las peticiones HTTP y las rutas
    // se accede a esta rusa para obtener los usuarios

    // Este es el contrato con los servicios
    @Autowired
    private UserService userService;
    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }
    //Cuando hacemos peticioneHTTP pues se le agrega el mapping
    @PostMapping
    // la anotacvion quiere decir que le vamos a enviar una request
    public UserModel saveUSer(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }
    // Se le va a pasar algo en la ruta esto es para algo Especifico por eso se le coloca en el path un ID
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getByid(id);
    }

   @PutMapping(path = "{id}")
    public UserModel updateUserById(@RequestBody UserModel request ,@PathVariable Long id){
    return this.userService.updateByID(request, id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User with id " + id + "Delete";
        }else{
            return "Error";
        }
    }
}
