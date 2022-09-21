package ltd.highsoft.monolithic.infra;

import ltd.highsoft.frameworks.domain.core.ValueSink;
import ltd.highsoft.frameworks.payload.core.Payload;
import org.springframework.web.bind.annotation.*;

import static ltd.highsoft.frameworks.domain.core.GlobalValueSinkFactory.createValueSink;
import static ltd.highsoft.frameworks.payload.core.StringFieldType.asString;

@RestController
public class PingApi {

    @PostMapping("/test/ping")
    public ValueSink ping(Payload payload) {
        return createValueSink(o -> o.put("pong", payload.get("ping", asString())));
    }

}
