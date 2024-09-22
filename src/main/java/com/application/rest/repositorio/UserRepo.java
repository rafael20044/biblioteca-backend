package com.application.rest.repositorio;

import com.application.rest.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface UserRepo extends JpaRepository<User, String>{
}
