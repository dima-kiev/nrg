package com.github.dimakiev.nrg.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.github.dimakiev.nrg.entities")
public class DBConfig extends AbstractR2dbcConfiguration {

    @Value("${host}") private String host;
    @Value("${port}") private Integer port;
    @Value("${user}") private String user;
    @Value("${pass}") private String password;
    @Value("${dbname}") private String dbName;

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                        PostgresqlConnectionConfiguration.builder()
                                .host(host)
                                .port(port)
                                .username(user)
                                .password(password)
                                .database(dbName)
                                //.options(options)
                                .build());
    }
}
