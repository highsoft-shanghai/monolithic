package ltd.highsoft.monolithic;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresContainer {

    protected static PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:13.6");

    static {
        POSTGRES.start();
        System.setProperty("spring.datasource.url", POSTGRES.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRES.getUsername());
        System.setProperty("spring.datasource.password", POSTGRES.getPassword());
    }

}
