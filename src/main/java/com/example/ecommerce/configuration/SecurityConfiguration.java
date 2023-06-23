package com.example.ecommerce.configuration;

import com.example.ecommerce.configuration.userdetailsservice.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.sessionManagement(sessionConfigurer ->
                        sessionConfigurer.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(customizer -> customizer.requestMatchers("/**", "/login/**",
                                "/resources/**", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .loginProcessingUrl("/auth").failureUrl("/login?error")
                        .usernameParameter("username").passwordParameter("password")
                        .defaultSuccessUrl("/products/", true))
                .logout(logoutConfigurer -> logoutConfigurer.logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true).clearAuthentication(true)
                        .logoutSuccessUrl("/login?logout"))
                .userDetailsService(this.userDetailsService);

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
