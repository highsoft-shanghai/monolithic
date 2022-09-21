package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.payload.core.Payload;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.*;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

import java.util.*;

public class PayloadHandlerMethodArgumentResolver extends AbstractMessageConverterMethodProcessor {

    protected PayloadHandlerMethodArgumentResolver(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Payload.class);
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer, @NonNull NativeWebRequest webRequest,
                                  @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Object arg = readWithMessageConverters(webRequest, parameter, LinkedHashMap.class.getGenericSuperclass());
        return new Payload(arg);
    }

    @Override
    public boolean supportsReturnType(@NonNull MethodParameter returnType) {
        return false;
    }

    @Override
    public void handleReturnValue(@Nullable Object returnValue, @NonNull MethodParameter returnType, @NonNull ModelAndViewContainer mavContainer,
                                  @NonNull NativeWebRequest webRequest) {

    }

}
