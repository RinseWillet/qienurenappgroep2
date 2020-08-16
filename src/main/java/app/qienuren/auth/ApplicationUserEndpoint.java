//package app.qienuren.auth;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/api/user")
//public class ApplicationUserEndpoint {
//
//    private final UserRepository userRepository;

   // @Autowired
  //  private JdbcTemplate jdbcTemplate;

//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//
//
//    public ApplicationUserEndpoint(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


//    @GetMapping("/all")
//    public Iterable<ApplicationUser> getUsers(){
//        applicationUserRepository.findAll();
//        return applicationUserService.allApplicationUsers();
//    }

//    @PostMapping("/add")
//    public ApplicationUser add(@RequestBody ApplicationUser user)     {
//        return myUserDetailsService.addNewApplicationUser(user);
//    }



//    @PutMapping("/")
//    public User update() {
//        User user = userRepository.findById(0).get();
//        user.setUsername("xxxx");
//        return userRepository.save(user);
//    }

//    @DeleteMapping("/")
//    public void delete() {
//        jdbcTemplate.execute("DELETE FROM APPLICATIONUSER");
//    }

//}
