package edu.eci.IETI.app.security;

import static edu.eci.IETI.app.utils.Constans.CLAIMS_ROLES_KEY;

import java.util.List;
import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import edu.eci.IETI.app.controllers.auth.TokenAuth;
import edu.eci.IETI.app.exception.TokenExpiredException;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtRequestFilter(JwtUtil jwtUtil){ this.jwtUtil = jwtUtil;}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        try {
            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                String jwt = authorizationHeader.substring(7);
                Claims claims = jwtUtil.extractAndVerifyClaims(jwt);
                String username = claims.getSubject();
                if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    List<String> roles = claims.get(CLAIMS_ROLES_KEY, List.class);
                    TokenAuth tokenAuth = new TokenAuth(username, null, roles);
                    SecurityContextHolder.getContext().setAuthentication(tokenAuth);

                }
            }
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredException();
        }
        filterChain.doFilter(request, response);
    }
}
