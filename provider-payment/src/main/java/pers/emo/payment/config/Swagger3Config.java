package pers.emo.payment.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {

    @Bean
    public GroupedOpenApi payApi() {
        return GroupedOpenApi.builder().group("支付模块").pathsToMatch("/pay/**").build();
    }

    @Bean
    public GroupedOpenApi otherApi() {
        return GroupedOpenApi.builder().group("其他模块").pathsToMatch("/other/**", "/others/**").build();
    }

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI().info(new Info().title("cloud_2024").description("通用设计 rest").version("v1.0"))
                .externalDocs(new ExternalDocumentation().description("不懂就去百度").url("https://www.baidu.com/"));
    }

}
