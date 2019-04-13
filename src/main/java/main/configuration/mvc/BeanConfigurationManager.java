package main.configuration.mvc;

import main.configuration.security.HashPasswordEncoder;
import main.configuration.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class BeanConfigurationManager {

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new HashPasswordEncoder();
    }
}
