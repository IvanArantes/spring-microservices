package br.com.ia.microservicecourseinit.services.user;

import br.com.ia.microservicecourseinit.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User findByName(String name);

    List<User> findAll();

    Optional<User> findById(Integer id);

    void deleteById(Integer id);
}
