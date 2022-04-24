package ltd.highsoft.frameworks.security.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GrantedDataAuthoritiesTest {

    @Test
    void should_be_able_to_hold_data_authorities() {
        DataAuthority authority1 = new DataAuthority();
        DataAuthority authority2 = new DataAuthority();
        assertThat(GrantedDataAuthorities.of(authority1, authority2).asList()).isEqualTo(List.of(authority1, authority2));
        assertThat(GrantedDataAuthorities.of(List.of(authority1, authority2)).asList()).isEqualTo(List.of(authority1, authority2));
    }

}
