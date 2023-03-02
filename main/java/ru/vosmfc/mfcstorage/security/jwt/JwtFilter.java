package ru.vosmfc.mfcstorage.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.vosmfc.mfcstorage.security.configuration.CustomUserDetails;
import ru.vosmfc.mfcstorage.security.service.CustomUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final static String AUTHORIZATION = "Authorization";

    @Autowired
    private final JwtProvider jwtProvider;

    @Autowired
    private final CustomUserDetailsService customUserDetailsService;

    public JwtFilter(JwtProvider jwtProvider, CustomUserDetailsService customUserDetailsService) {
        this.jwtProvider = jwtProvider;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromRequest(request);

        if (token != null && jwtProvider.validateToken(token)) {
            String userName = jwtProvider.getLoginFromToken(token);
            CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userName);

            if (!customUserDetails.isAccountNonLocked()) {
                response.setStatus(403);
                return;
            }

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);

        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }

        return null;
    }

}
