package app.qienuren.auth;

import app.qienuren.model.Persoon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Persoon,Long> {
    Optional<Persoon> findByUserName(String userName);



    //@Query(value = "SELECT  FROM ApplicationUser u")
//    Iterable<ApplicationUser>findAllUsers();
//
//    ApplicationUser findApplicationUsersBy(String name);//SELECT * FROM user WHERE username=(name)

    //--> WebSecurityConfig--> UserRepositoryUserDetailsService --> UserRepository
}
