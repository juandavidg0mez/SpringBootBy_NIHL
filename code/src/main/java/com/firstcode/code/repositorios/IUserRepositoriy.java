package com.firstcode.code.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.firstcode.code.models.UserModel;

// Un repository es Clase que permite hace querys a una base de datos nos permiten hacer consultas
@Repository
public interface IUserRepositoriy extends JpaRepository<UserModel, Long> {
        

}
