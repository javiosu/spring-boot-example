package org.skh.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;


@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableJpaRepositories(basePackages = "org.skh.repository.portal", entityManagerFactoryRef = "portalEntityManager", transactionManagerRef = "portalTransactionManager")
public class DatabaseConfiguration {

    private final Environment env;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean portalEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(portalDataSource());
        em.setPackagesToScan("org.skh.repository.portal", "org.skh.domain.portal");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(env.getProperty("spring.jpa.database-platform"));
        vendorAdapter.setDatabase(Database.SQL_SERVER);
        vendorAdapter.setShowSql(false);

        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap();
        String[] hibernateProperties =
            new String[]{"hibernate.id.new_generator_mappings", "hibernate.connection.provider_disables_autocommit", "hibernate.cache.use_second_level_cache",
                "hibernate.cache.use_query_cache",
                "hibernate.generate_statistic"};

        Arrays.asList(hibernateProperties)
            .forEach(item -> properties.put(item, env.getProperty(item)));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties portalDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.member.configuration")
    public DataSource portalDataSource() {
        return portalDataSourceProperties().initializeDataSourceBuilder()
            .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager portalTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(portalEntityManager().getObject());
        return transactionManager;
    }
}
