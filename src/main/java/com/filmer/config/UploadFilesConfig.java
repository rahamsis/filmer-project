package com.filmer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadFilesConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/portadas/**").addResourceLocations("file:/D:/Rahamsis/Programas/Spring Boot/Proyectos con Spring/workspace-sts-4-4.11.0.RELEASE/filmer/portadas/");
	}
	
}
