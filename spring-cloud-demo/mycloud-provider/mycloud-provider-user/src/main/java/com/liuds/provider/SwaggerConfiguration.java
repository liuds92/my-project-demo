package com.liuds.provider;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket createRestApi() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<>();
		tokenPar.name("Authorization").description("token")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.build();
		pars.add(tokenPar.build());

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select()
				//扫描指定包中的swagger注解
				//扫描所有有注解的api，用这种方式更灵活
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(pars);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("海承学车小程序 RESTful APIs")
				.description("海承学车小程序 RESTful 风格的接口文档，内容详细，极大的减少了前后端的沟通成本，同时确保代码与文档保持高度一致，极大的减少维护文档的时间。")
				.termsOfServiceUrl("http://www.haichengxy.com")
				.version("1.0.0")
				.build();
	}
}