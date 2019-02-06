package br.com.ia.microservicecourseinit.resources;


import br.com.ia.microservicecourseinit.configs.exceptions.UserNotFoundException;
import br.com.ia.microservicecourseinit.model.User;
import br.com.ia.microservicecourseinit.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public List<User> listUsers(){
       return userService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Resource<User> findUser(@Valid @PathVariable Integer id) {
       User user= userService.findById(id).orElseThrow(() -> new UserNotFoundException("User was not found"));

        //Linka a chamada do método listUsers no retorno dessa requisição (HATEOAS)
        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).listUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return new User();
    }

    @GetMapping(path="/users-internationalized")
    public String sayHelloToUser(){
        return messageSource.getMessage("good.morming.message", null, LocaleContextHolder.getLocale());
    }


}
