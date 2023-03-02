package ru.vosmfc.mfcstorage.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.vosmfc.mfcstorage.security.jwt.JwtFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final JwtFilter jwtFilter;

    @Autowired
    private final AuthEntryPoint authEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter,
                          AuthEntryPoint authEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.authEntryPoint = authEntryPoint;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
                                                       BCryptPasswordEncoder bCryptPasswordEncoder,
                                                       UserDetailsService userDetailsService) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().cors()
                .and().authorizeRequests().anyRequest().permitAll();

        httpSecurity.httpBasic().disable()
                .csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/departments").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/departments").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/item_categories").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/item_categories").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/items").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/items/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/items/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/items").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/item_expenses").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/item_expenses/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/item_expenses/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/item_expenses").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/item_incomes").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/item_incomes/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/item_incomes/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/item_incomes").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/positions").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/positions").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/recipients").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/recipients/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/recipients/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/recipients").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/storages").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/storages/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/storages/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/storages").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/item_expense_between_date").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/item_income_between_date").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/storage_by_item_name").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/item_expense_by_item_name").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/item_income_by_item_name").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);
        configuration.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
