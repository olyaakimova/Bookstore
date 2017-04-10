package fi.haagehelia.course;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fi.haagehelia.course.web.UserDetailServiceClass;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private UserDetailServiceClass userDetailsService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests().antMatchers("/css/**").permitAll()
		    .and()
		    .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll()
		    .and()
		    .authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
            .loginPage("/login")                       //login-page
            //.failureUrl("/login.html?status=LOGIN_FAILURE") //authentication-failure-url
            .defaultSuccessUrl("/booklist", false) //default-target-url. set always-use-default-target to `false`
            .permitAll()
			.and()
			.logout()
			.permitAll();
		}
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}
	}