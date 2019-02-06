package br.com.ia.microservicecourseinit.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {


    @GetMapping("v1/person")
    public PersonV1 getPersonV1(){
    return new PersonV1("Ivan");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("Ivan", "Arantes"));
    }


    //Other option
    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Ivan");
    }

    @GetMapping(value = "person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Ivan", "Arantes"));
    }

    //Other option
    @GetMapping(value = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Ivan");
    }

    @GetMapping(value = "person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Ivan", "Arantes"));
    }

    //Other option
    @GetMapping(value = "person/produces", produces = "application/vnd.br.com.ia.v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Ivan");
    }

    @GetMapping(value = "person/produces", produces = "application/vnd.br.com.ia.v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Ivan", "Arantes"));
    }
}
