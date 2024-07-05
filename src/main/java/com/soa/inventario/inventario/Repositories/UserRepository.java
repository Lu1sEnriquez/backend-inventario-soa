package com.soa.inventario.inventario.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.soa.inventario.inventario.Entities.User;
import java.util.Optional;


public interface UserRepository  extends CrudRepository<User, Integer>{

    Optional<User> findByUsername(String username);
}
