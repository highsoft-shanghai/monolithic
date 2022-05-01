package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.application.core.ApplicationException;
import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import ltd.highsoft.frameworks.security.core.AccessTokenProvider;
import ltd.highsoft.frameworks.test.context.WithSecurityContext;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@WithSecurityContext(grantedAuthorities = "f1")
public class UseCaseAspectTest {

    private @Resource TriggerExceptionUseCase triggerExceptionUseCase;
    private @Resource TestUseCase testUseCase;
    private @MockBean AccessTokenProvider accessTokenProvider;

    @BeforeEach
    void setUp() {
        given(accessTokenProvider.get(any())).willReturn(Optional.empty());
    }

    @Test
    void should_be_able_to_translate_exceptions() {
        Throwable throwable = catchThrowable(() -> triggerExceptionUseCase.execute(new RuntimeException("error-code")));
        assertThat(throwable).isInstanceOf(ApplicationException.class);
    }

    @Test
    void should_be_able_to_translate_aggregate_not_found_exceptions() {
        Throwable throwable = catchThrowable(() -> triggerExceptionUseCase.execute(new AggregateNotFoundException("error-code")));
        assertThat(throwable).isInstanceOf(ApplicationException.class);
        assertThat(throwable).hasMessage("error-code");
    }

    @Test
    void should_delegate_execution_to_use_cases() {
        assertThat(testUseCase.execute("test")).isEqualTo("executed with 'test'");
    }

}
