package ltd.highsoft.frameworks.application.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import static com.google.common.collect.Lists.newArrayList;

class PayloadHandlerMethodArgumentResolverTest {

    @Test
    void should_return_false() {
        PayloadHandlerMethodArgumentResolver payloadHandlerMethodArgumentResolver = new PayloadHandlerMethodArgumentResolver(newArrayList(new MappingJackson2HttpMessageConverter()));
        Assertions.assertThat(payloadHandlerMethodArgumentResolver.supportsReturnType(null)).isFalse();
        Throwable throwable = Assertions.catchThrowable(() -> payloadHandlerMethodArgumentResolver.handleReturnValue(null, null, null, null));
        Assertions.assertThat(throwable).isNull();
    }

}
