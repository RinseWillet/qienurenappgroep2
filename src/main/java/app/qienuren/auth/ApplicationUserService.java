//package app.qienuren.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service("ApplicationUserService")
//public class ApplicationUserService implements UserDetailsService {
//
//    private final ApplicationUserRepository applicationUserRepository;
//
//    @Autowired
//    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
//        this.applicationUserRepository = applicationUserRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ApplicationUser user = applicationUserRepository.findApplicationUsersBy(username);
//        if (user != null) {
//            return user;
//        }
//        throw new UsernameNotFoundException(
//                "User '" + username + "' not found");
//    }
//
//    public ApplicationUser addNewApplicationUser(ApplicationUser applicationUser){
//        System.out.println("Nieuwe gebruiker aangemaakt");
//        return applicationUserRepository.save(applicationUser);
//    }
//
//    public Iterable<ApplicationUser> allApplicationUsers(){
//        System.out.println("alle gebruikers");
//        return applicationUserRepository.findAllUsers();
//    }
//
//}
