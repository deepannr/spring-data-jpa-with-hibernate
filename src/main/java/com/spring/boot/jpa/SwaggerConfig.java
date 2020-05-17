package com.spring.boot.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	// Both DEFAULT_CONTACT, DEFAULT copied from ApiInfo Class
	private static final Contact DEFAULT_CONTACT = new Contact("Deepan", "www.deepan.com", "deepannr@gmail.com");
	@SuppressWarnings("rawtypes")
	private static final ApiInfo DEFAULT = new ApiInfo("SpringBootMicroSvs", "Spring Boot with Micro Services", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());

	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	private static final Set<String> DEFAULT_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).consumes(DEFAULT_CONSUMES)
				.produces(DEFAULT_PRODUCES);
	}
}
