package br.com.ia.microservicecourseinit.repository.user;


import br.com.ia.microservicecourseinit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    static List<User> users = new ArrayList<User>(){{
//       add(new User("Ivan", "Arantes", LocalDate.of(1994,3,31), "M"));
//        add(new User("Renata", "Albernaz", LocalDate.of(1987,7,15), "F"));
//        add(new User("Allan", "Arantes", LocalDate.of(1994,3,31), "M"));
//    }};

//
//    @Override
//    public User findByName(String name) {
//        for (User user: users) {
//            if(user.getName().equalsIgnoreCase(name)){
//                return user;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return users;
//    }
}
