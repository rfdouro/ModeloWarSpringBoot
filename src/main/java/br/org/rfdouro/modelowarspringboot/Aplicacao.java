/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.modelowarspringboot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author romulo.douro
 * 
 * para executar após o build
 * java -jar target\ModeloWarSpringBoot-1.0.war
 */
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("br.org.rfdouro.modelowarspringboot")
//@EnableWebMvc
public class Aplicacao extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
 
 @Value("${spring.mvc.view.prefix:/WEB-INF/jsp/}")
 private String prefixo;
 @Value("${spring.mvc.view.suffix:.jsp}")
 private String sufixo;

 public static void main(String[] args) {
  SpringApplication.run(Aplicacao.class, args);
 }
 
 //****WebMvcConfigurer
 
 @Override
 public void configureViewResolvers(ViewResolverRegistry registry) {
  //registry.jsp("/WEB-INF/jsp/", ".jsp");
  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
  resolver.setPrefix(prefixo);
  resolver.setSuffix(sufixo);
  resolver.setViewClass(JstlView.class);
  registry.viewResolver(resolver);
 }
 
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
  // Register resource handler
  registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");//.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
 }
 
 @Override
 public void addCorsMappings(CorsRegistry registry) {
  registry.addMapping("/**");
 }
 
 //****ServletInitializer
 
 @Override
 public void onStartup(ServletContext servletContext) throws ServletException {
  AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
  ctx.register(Aplicacao.class);
  ctx.setServletContext(servletContext);
  ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
  servlet.addMapping("/");
  servlet.setLoadOnStartup(1);
 }

 @Override
 protected Class<?>[] getRootConfigClasses() {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 protected Class<?>[] getServletConfigClasses() {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }

 @Override
 protected String[] getServletMappings() {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
}
