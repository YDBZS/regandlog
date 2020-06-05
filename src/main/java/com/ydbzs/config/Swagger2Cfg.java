package com.ydbzs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2接口文档配置
 *
 * @author ：Axel
 * @date ：2020/6/5 14:51
 */
@Configuration
@EnableSwagger2
public class Swagger2Cfg {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ydbzs.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("这是一个用于用户登录注册的SpringBoot Demo!")
                .description("This is a Demo for SpringBoot!!")
                .termsOfServiceUrl("http://localhost:8080")
                .version("v3.6")
                .contact(new Contact("詹姆斯 ~ 高斯林", "https://localhost:8080", "y908036221@gmail.com"))
                .build();

    }

}

