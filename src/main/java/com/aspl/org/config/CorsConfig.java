package com.aspl.org.config;

import java.util.Arrays;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
	
	
	  @Override 
	  public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*").allowedHeaders("*"); 
	  }
	 
	
	/*
	 * public WebMvcConfigurer corsConfigurer() { return new WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**"); } }; }
	 */
	
	
	/*
	 * @Bean public ConfigurableServletWebServerFactory webServerFactory() {
	 * TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	 * factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
	 * 
	 * @Override public void customize(Connector connector) {
	 * connector.setProperty("relaxedQueryChars", "|{}[]"); } }); return factory; }
	 * 
	 * 
	 * 
	 * @Bean CorsConfigurationSource corsConfigurationSource() {
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); CorsConfiguration corsConfiguration = new
	 * CorsConfiguration(); corsConfiguration.addAllowedOrigin("192.168.0.46");
	 * corsConfiguration.setAllowedMethods(Arrays.asList( HttpMethod.GET.name(),
	 * HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
	 * HttpMethod.DELETE.name())); corsConfiguration.setMaxAge(1800L);
	 * source.registerCorsConfiguration("/**", corsConfiguration); // you restrict
	 * your path here return source; }
	 */
	
}
