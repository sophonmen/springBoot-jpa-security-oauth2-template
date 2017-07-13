package com.backend;

import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.backend.config.CustomUserDetails;
import com.backend.dao.UserRepository;
import com.backend.domain.Role;
import com.backend.domain.User;
import com.backend.service.RoleService;
import com.backend.service.UserService;

@ComponentScan(basePackages = "com.backend")
@SpringBootApplication
public class TestApplication {

    @Autowired
    RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository, UserService service)
            throws Exception {
        try {
            if (userRepository.count() == 0) {
                Set<Role> roles = new TreeSet<>();
                Role r1 = new Role("ROLE_ADMIN");
                Role r2 = new Role("ROLE_USER");
                roleService.save(r1);
                roleService.save(r2);
                roles.add(r1);
                roles.add(r2);
                service.save(new User("admin", "admin", roles));
            }
            builder.userDetailsService(userDetailsService(userRepository)).passwordEncoder(getPasswordEncoder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }
}
