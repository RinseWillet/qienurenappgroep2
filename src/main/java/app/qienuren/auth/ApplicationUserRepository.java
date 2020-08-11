package app.qienuren.auth;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Long> {
    //@Query(value = "SELECT  FROM ApplicationUser u")
    Iterable<ApplicationUser>findAllUsers();

    ApplicationUser findApplicationUsersBy(String name);//SELECT * FROM user WHERE username=(name)

    //--> WebSecurityConfig--> UserRepositoryUserDetailsService --> UserRepository
}
