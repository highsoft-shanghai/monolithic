package ltd.highsoft.frameworks.security.core;

import java.util.Optional;

public interface ContextProvider {

    Optional<Context> get(String id);

}
