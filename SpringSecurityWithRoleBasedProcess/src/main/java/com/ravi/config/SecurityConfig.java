package com.ravi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ravi.service.EmployeeCustomDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private EmployeeCustomDetailsService employeeCustomDetailsService;

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/employees/welcome").permitAll()
        .requestMatchers("/employees/create").hasRole("HR")
        .requestMatchers("/employees/all").hasAnyRole("HR", "MANAGER")
        .requestMatchers("/employees/**").hasRole("EMPLOYEE")
        .anyRequest().authenticated()
        .and()
        .httpBasic();
		return http.build();	 
    }
	
	/*
	 * @Bean public UserDetailsService userDetailsService() { return
	 * employeeCustomDetailsService; }
	 */
	 
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	  }
	
		/*
		 * @Bean public AuthenticationManager authenticationManager() {
		 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		 * authProvider.setUserDetailsService(employeeCustomDetailsService);
		 * authProvider.setPasswordEncoder(passwordEncoder()); return new
		 * ProviderManager(authProvider); }
		 */		 
	
		/*
		 * @Bean public AuthenticationProvider authenticationProvider() {
		 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		 * authProvider.setUserDetailsService(userDetailsService());
		 * authProvider.setPasswordEncoder(passwordEncoder()); return authProvider; }
		 */

	
	 
}
