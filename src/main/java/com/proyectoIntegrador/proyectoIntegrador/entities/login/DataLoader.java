package com.proyectoIntegrador.proyectoIntegrador.entities.login;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("password");
        String password2 = encoder.encode("password2");

        userRepository.save(new AppUser("Flavio","Bernachia","flaviobernachia@gmail.com","Admin", password,AppUserRoles.ADMIN));
        userRepository.save(new AppUser("Flavio1","Bernachia1","flaviobernachia1@gmail.com","User", password2,AppUserRoles.USER));

    }
}
