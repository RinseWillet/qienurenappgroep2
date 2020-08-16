package app.qienuren.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import static java.util.Arrays.asList;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
  //  private boolean active;
    private String roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


}
//
//    @Id
//    private long id;
//    private String username;
//    private String password;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return asList(new SimpleGrantedAuthority("ROLE_USER"));
//
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername () {
//            return username;
//        }
//
//        public void setUsername (String username){
//            this.username = username;
//    }
//    @Override
//    public boolean isAccountNonExpired () {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked () {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired () {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled () {
//        return true;
//    }


