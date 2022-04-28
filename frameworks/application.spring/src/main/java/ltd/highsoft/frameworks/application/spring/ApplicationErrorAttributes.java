package ltd.highsoft.frameworks.application.spring;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.util.Map;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;

public class ApplicationErrorAttributes extends DefaultErrorAttributes {

    private @Resource ExceptionFormatter exceptionFormatter;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
        Map<String, Object> error = super.getErrorAttributes(request, ErrorAttributeOptions.of(MESSAGE));
        Throwable throwable = getError(request);
        error.put("message", throwable == null ? "" : exceptionFormatter.format(throwable));
        return error;
    }

}
