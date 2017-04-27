package br.com.kleber.shop.service.security;

import br.com.kleber.shop.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHelper {

    private final JWTService jwtService;

    public AuthenticationHelper(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    public Authentication auth(Customer customer) throws JsonProcessingException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword(), null);
        authenticationToken.setDetails(customer);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authenticationToken);
        return authenticationToken;
    }
}
