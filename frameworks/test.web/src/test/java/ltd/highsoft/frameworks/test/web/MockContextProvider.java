package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class MockContextProvider implements ContextProvider {

    @Override
    public Optional<Context> get(String id) {
        return StringUtils.equals(GlobalTestContext.token().orElse(""), id) ? GlobalTestContext.context() : Optional.empty();
    }

}
