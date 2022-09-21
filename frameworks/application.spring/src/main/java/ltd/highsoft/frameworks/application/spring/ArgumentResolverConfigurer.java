package ltd.highsoft.frameworks.application.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
public class ArgumentResolverConfigurer implements WebMvcConfigurer {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PayloadHandlerMethodArgumentResolver(newArrayList(new MappingJackson2HttpMessageConverter())));
    }


}
