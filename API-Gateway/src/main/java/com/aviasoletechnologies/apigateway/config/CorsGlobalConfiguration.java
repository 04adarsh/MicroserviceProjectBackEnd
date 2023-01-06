//package com.aviasoletechnologies.apigateway.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.CorsRegistry;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
//@Configuration
//@EnableWebFlux
//public class CorsGlobalConfiguration implements WebFluxConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        corsRegistry.addMapping("/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
//                .allowedHeaders("Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization")
//                .maxAge(3600);
//    }
//}