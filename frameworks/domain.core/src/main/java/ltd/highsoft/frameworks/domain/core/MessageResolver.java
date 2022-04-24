package ltd.highsoft.frameworks.domain.core;

import java.util.Locale;

public interface MessageResolver {

    String resolve(String code, Object... args);

    String resolve(String code, Locale locale, Object... args);

}
