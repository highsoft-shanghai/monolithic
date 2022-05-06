package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.*;

import java.util.Optional;

public class WithTestAuthoritiesContextProvider implements ContextProvider {

    private final ContextProvider contextProvider;

    public WithTestAuthoritiesContextProvider(ContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override
    public Optional<Context> get(String id) {
        return contextProvider.get(id).map(WithTestAuthoritiesContext::new);
    }

}
