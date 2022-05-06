package ltd.highsoft.frameworks.test.web;

import ltd.highsoft.frameworks.security.core.ContextProvider;

public class ContextProviderHolder {

    private final ContextProvider contextProvider;

    public ContextProviderHolder(ContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    public ContextProvider contextProvider() {
        return contextProvider;
    }

}
