package br.com.kleber.shop.configuration;

import br.com.kleber.shop.service.security.SecurityHttpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by kleber on 4/24/17.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final SecurityHttpFilter securityHttpFilter;

    @Autowired
    public SecurityConfiguration(
            SecurityHttpFilter securityHttpFilter) {
        this.securityHttpFilter = securityHttpFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl();
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/secure/**").authenticated()
                .and()
                .addFilterBefore(securityHttpFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("moip@email.com").password("moip").roles("USER");
    }
}