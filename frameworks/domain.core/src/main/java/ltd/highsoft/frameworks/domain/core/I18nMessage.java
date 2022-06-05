package ltd.highsoft.frameworks.domain.core;

import java.util.List;

public final class I18nMessage {

    private final String code;
    private final Object[] data;

    public static I18nMessage message(String code, Object... data) {
        return new I18nMessage(code, data);
    }

    public String format(MessageResolver messageResolver) {
        return messageResolver.resolve(code, data);
    }

    public List<Object> data() {
        return List.of(data);
    }

    private I18nMessage(String code, Object[] data) {
        this.code = code;
        this.data = data;
    }

}
