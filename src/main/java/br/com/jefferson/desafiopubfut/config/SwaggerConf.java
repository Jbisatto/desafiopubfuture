package br.com.jefferson.desafiopubfut.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConf {
	  @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("desafiopufut")
	              .pathsToMatch("/**")
	              .build();
	  }
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Controle de Finanças")
	              .description("DESAFIO DE PROGRAMAÇÃO - PubFuture")
	              .version("v0.0.1"))
	              .externalDocs(new ExternalDocumentation());
	  }

	  
	  }
