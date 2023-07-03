package io.management.pharmacy.filter;

import io.management.pharmacy.exceptions.InvalidAuthorizationTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor, Ordered {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String CODENAME = "TokenInterceptor";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Inside {}#preHandle", CODENAME);

        // Extract the token from the request headers or query parameters
        String token = extractToken(request);
        UserDetails userDetails = getUserDetailsFromToken(token);

        // Validate the token using jwtUtil
        boolean isValidToken = jwtUtil.validateToken(token, userDetails);

        if (isValidToken) {
            // Allow the request to proceed
            return true;
        }
        else {
            // Todo: to handle exception or error accordingly?
            log.error("Invalid Token");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

    private UserDetails getUserDetailsFromToken(String token) {
        log.info("Inside {}#getUserDetailsFromToken", CODENAME);
        String userName = jwtUtil.getUsernameFromToken(token);

        // Load user details by using userDetailsService
        return userDetailsService.loadUserByUsername(userName);
    }

    private String extractToken(HttpServletRequest request) {
        log.info("Inside {}#extractToken", CODENAME);
        // Extract the token from header in request
        String authorizationHeader = request.getHeader("Authorization");

        // Check if the Authorization header is present and starts with "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // extract the token by removing the "Bearer " prefix
            return authorizationHeader.substring(7);
        }

        // Return null or throw an exception if token is not found
        throw new InvalidAuthorizationTokenException("Invalid auth token or no token found");
    }

    @Override
    public int getOrder() {
        // to set the order of interceptor to execute before spring security
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
