package app.qienuren.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("ApplicationUserService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll() //dit zorgt ervoor dat de login pagina aangepast kan worden en laat login.html zien (zie templates)
                    .defaultSuccessUrl("/Inlogsucces",true) //dit zorgt ervoor na het inloggen// dat je op deze pagina terecht komt, zie html in map templates en de getmapping in templatecontroller
                    .passwordParameter("password") //moet hetzelfde zijn als name in login.html
                    .usernameParameter("username")
                .and()
                    .rememberMe() //zodat de gebruiker onthouden wordt (staat default op 2 weken)
                    .rememberMeParameter("remember-me")// -->userdetailservice nog implementeren anders werkt dit niet
                .and()
                    .logout() //dit gedeelte zorgt voor een logout, en verwijdert cookies, je komt weer terecht op login pagina
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");

    }
}
