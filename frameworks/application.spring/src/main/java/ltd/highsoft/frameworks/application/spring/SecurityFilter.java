package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.security.core.ContextLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@Component
@WebFilter("/**")
public class SecurityFilter extends OncePerRequestFilter {

    private @Resource ContextLoader contextLoader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try (HttpHeaderContextLoader loader = new HttpHeaderContextLoader(contextLoader)) {
            loader.load(request);
            filterChain.doFilter(request, response);
        }
    }

}
