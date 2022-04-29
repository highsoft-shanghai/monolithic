package ltd.highsoft.frameworks.test.web;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/web-test")
public class WebTestController {

    @GetMapping("simple-get")
    public Object simpleGet() {
        return Map.of("name", "John");
    }

}
