package com.CorrencyConverter.CorrencyConverter.jwtFilter;

import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import com.CorrencyConverter.CorrencyConverter.repo.UserRepo;
import com.CorrencyConverter.CorrencyConverter.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {  // 7. make jwt filter

    private final JwtService jwtService;
    private final UserRepo userRepo;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


try{
    final String requestHeader = request.getHeader("Authorization");
    if(requestHeader==null || !requestHeader.startsWith("Bearer")){
        filterChain.doFilter(request,response);
        return;
    }
    String token = requestHeader.split("Bearer ")[1];
    Long userId =  jwtService.getUserIdFromToken(token);

    // now use this userId to access User data

    if(userId!=null || SecurityContextHolder.getContext().getAuthentication()==null){
        assert userId != null;
        UserEntity user = userRepo.findById(userId).orElse(null);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user,null,null);
        new WebAuthenticationDetailsSource().buildDetails(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    filterChain.doFilter(request,response);

}catch (Exception e){
    handlerExceptionResolver.resolveException(request,response,null,e);
}
    }
}
