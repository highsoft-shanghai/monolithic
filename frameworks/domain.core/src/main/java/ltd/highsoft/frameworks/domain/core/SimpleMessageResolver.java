package ltd.highsoft.frameworks.domain.core;

import org.apache.commons.lang3.StringUtils;

public class SimpleMessageResolver implements MessageResolver {

    @Override
    public String resolve(String code, Object... args) {
        return code + ": [" + StringUtils.joinWith(", ", args) + "]";
    }

}
