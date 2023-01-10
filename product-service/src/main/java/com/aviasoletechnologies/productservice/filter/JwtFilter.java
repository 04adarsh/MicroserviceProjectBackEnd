//package com.aviasoletechnologies.productservice.filter;
//
//
//import io.jsonwebtoken.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//public class JwtFilter extends GenericFilterBean {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        final HttpServletRequest request = (HttpServletRequest) servletRequest;
//        final HttpServletResponse response = (HttpServletResponse) servletResponse;
//        final String token = request.getHeader("Authorization");
//
//
//
//        try {
//            if ("OPTIONS".equals(request.getMethod())) {
//                response.setStatus(HttpServletResponse.SC_OK);
//                filterChain.doFilter(request, response);
//            } else {
//                if (token == null) {
//                    throw new ServletException("An exception occurred");
//                }
//
//                Claims claims = Jwts.parser().setSigningKey("codeusingjavaSecret").parseClaimsJws(token).getBody();
//                request.setAttribute("claims", claims);
//                filterChain.doFilter(request, response);
//            }
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        } catch (ExpiredJwtException e) {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(),"JWT has expired");
//        } catch (UnsupportedJwtException e) {
//            throw new RuntimeException(e);
//        } catch (MalformedJwtException e) {
//            throw new RuntimeException(e);
//        } catch (SignatureException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}
