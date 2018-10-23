package pl.piomin.services.account;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class AccountApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(AccountApplication.class).web(true).run(args);
	}
	
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
				.apis(RequestHandlerSelectors.basePackage("pl.piomin.services.account"))
				.paths(any())
			.build()
			.apiInfo(new ApiInfoBuilder().version("1.0").title("Account API").description("Documentation Account API v1.0").build());
	}
	
	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().docExpansion(DocExpansion.LIST).build();
	}
	
}
