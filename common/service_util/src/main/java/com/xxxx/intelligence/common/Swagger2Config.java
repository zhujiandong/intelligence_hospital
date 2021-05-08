package com.xxxx.intelligence.common;

import com.google.common.base.Predicates;
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

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .apiInfo(adminApiInfo())
                .select()
                // 只显示admin路径
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }


    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("web")
                .apiInfo(webApiInfo())
                .select()
                // 只显示web路径
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }


    /**
     * 设置接口信息
     *
     * @return
     */
    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("admin接口文档")
                .description("admin管理员接口文档")
                .contact(new Contact("朱健东", "", ""))
                .version("1.0")
                .build();
    }


    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("web接口文档")
                .description("web接口文档")
                .contact(new Contact("朱健东", "", ""))
                .version("1.0")
                .build();
    }

}
