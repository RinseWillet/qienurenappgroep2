//package app.qienuren.auth;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.util.Collection;
//
//
//import static java.util.Arrays.asList;
//
//@Entity
//public class ApplicationUser implements UserDetails {
//
//    @Id
//    private long id;
//    private String password;
//    private String username;
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
//}
//
