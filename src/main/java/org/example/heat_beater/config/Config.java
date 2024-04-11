//package org.example.heat_beater.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class Config implements WebMvcConfigurer {
//
//
//
//        @Override
//        public void addViewControllers(ViewControllerRegistry registry) {
//            registry.addViewController("/").setViewName("forward:/index.html");
//
//        }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(a -> a.anyRequest().permitAll());
//
////                anyRequest().authenticated());
//            return http.build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//       var u = new InMemoryUserDetailsManager();
//         UserDetails user = User.withUsername("user")
//                .passwordEncoder(password -> passwordEncoder().encode(password))
//                .password("1234")
//                .build();
//        u.createUser(user);
//        return u;
//    }
//
//    @Bean
//    protected BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//}
