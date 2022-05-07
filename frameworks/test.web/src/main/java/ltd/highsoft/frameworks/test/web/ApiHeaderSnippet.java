package ltd.highsoft.frameworks.test.web;

import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.snippet.TemplatedSnippet;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaderSnippet extends TemplatedSnippet {
    private final boolean authorizationRequired;

    protected ApiHeaderSnippet(boolean authorizationRequired) {
        super("api-header", null);
        this.authorizationRequired = authorizationRequired;
    }

    @Override
    protected Map<String, Object> createModel(Operation operation) {
        Map<String, Object> model = new HashMap<>();
        model.put("urlTemplate", getUrlTemplate(operation));
        model.put("httpMethod", operation.getRequest().getMethod());
        model.put("authorizationRequired", authorizationRequired ? "Yes" : "No");
        return model;
    }

    private Object getUrlTemplate(Operation operation) {
        String key = "org.springframework.restdocs.urlTemplate";
        Object value = operation.getAttributes().getOrDefault(key, null);
        return (value == null) ? operation.getRequest().getUri().getPath() : value;
    }
}
