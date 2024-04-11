package org.example.heat_beater.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


     http
             .csrf(c -> {
                 try {
                     c.disable()


                .authorizeHttpRequests(a -> a
                        .requestMatchers("/login").hasAnyRole("user", "admin")
                        .anyRequest().authenticated()
                )
                        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
                        )
                        .logout(l -> l
                                .logoutSuccessUrl("/").permitAll());
                 } catch (Exception e) {
                     throw new RuntimeException(e);
                 }
             });

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(a -> a
//                        .requestMatchers("/login").hasAnyRole("user", "admin")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
//                )
//                .logout(l -> l
//
//                        .logoutSuccessUrl("/").permitAll());
//
//        return http.build();
//    }


    @Bean
    public UserDetailsService userDetailsService() {
       var u = new InMemoryUserDetailsManager();
         UserDetails user = User.withUsername("user")
                .passwordEncoder(password -> passwordEncoder().encode(password))
                .password("1234").roles("user")
                .build();
         UserDetails admin = User.withUsername("admin")
                .passwordEncoder(password -> passwordEncoder().encode(password))
                .password("1234").roles("admin")
//                .authorities("user","admin")
                .build();

        u.createUser(user);
        u.createUser(admin);
        return u;
    }

    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}
