package application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   private JWTProvider provider;
    public WebSecurityConfig(JWTProvider provider){
        this.provider = provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests()//
                .antMatchers("/signin").permitAll()//
                .antMatchers("/signup").permitAll()//
                .and()// Disallow everything else..
                .authorizeRequests()
                .anyRequest().authenticated();

        // Apply JWT
        http.addFilterBefore(new JWTFilter(provider), UsernamePasswordAuthenticationFilter.class);
        // Optional, if you want to test the API from a browser
        // http.httpBasic();
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/signup","/signin");
    }

}
