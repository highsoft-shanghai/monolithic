package ltd.highsoft.monolithic;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresContainer extends TestContainer<PostgreSQLContainer<?>> {

    @Override
    protected PostgreSQLContainer<?> container() {
        return new PostgreSQLContainer<>("postgres:13.6");
    }

    @Override
    protected void environment() {
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());
    }

}
