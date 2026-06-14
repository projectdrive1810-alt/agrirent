package com.agrirent.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;

import com.agrirent.entity.User;
import com.agrirent.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.agrirent.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
                extends OncePerRequestFilter {

        private final JwtService jwtService;
        private final UserRepository userRepository;

        @Override
        protected void doFilterInternal(
                        HttpServletRequest request,
                        HttpServletResponse response,
                        FilterChain filterChain)
                        throws ServletException, IOException {

                String authHeader = request.getHeader("Authorization");

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {

                        filterChain.doFilter(request, response);
                        return;
                }

                String token = authHeader.substring(7);

                if (jwtService.validateToken(token)) {

                        String email = jwtService.extractEmail(token);

                        User user = userRepository.findByEmail(email)
                                        .orElse(null);

                        System.out.println("JWT Email: " + email);
                        System.out.println("User Found: " + user);

                        if (user == null) {
                                filterChain.doFilter(request, response);
                                return;
                        } else {
                                Authentication auth = new UsernamePasswordAuthenticationToken(
                                                user,
                                                null,
                                                null);

                                SecurityContextHolder.getContext().setAuthentication(auth);
                        }
                }

                filterChain.doFilter(request, response);
        }
}