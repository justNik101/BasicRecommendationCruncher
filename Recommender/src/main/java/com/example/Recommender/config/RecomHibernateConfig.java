package com.example.Recommender.config;

import com.example.Recommender.constants.RecommendationProperties;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@ConditionalOnProperty(name = RecommendationProperties.MOCK_OBJECT_PROPERTY_KEY, havingValue = "false")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {RecommendationProperties.RECOMMENDATION_DB_BASE_PATH},
        entityManagerFactoryRef = "recommEntityManagerFactory",
        transactionManagerRef = "recommTransactionManager")
public class RecomHibernateConfig {
    @Value("${mysql.recommendation.datasource.url}")
    private String mysqlURI;
    @Value("${mysql.recommendation.datasource.username}")
    private String mysqlUserName;
    @Value("${mysql.recommendation.datasource.password}")
    private String mysqlPassword;

    @Value("${mysql.recommendation.datasource.max.poolsize:5}")
    private Integer maxPoolSize;

    @Bean
    public DataSource recommendDataSource() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(mysqlURI);
        dataSourceProperties.setUsername(mysqlUserName);
        dataSourceProperties.setPassword(mysqlPassword);
        HikariDataSource hikariDataSource = dataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
        hikariDataSource.setMaximumPoolSize(maxPoolSize);
        return hikariDataSource;
    }

    @PersistenceContext(unitName = "recommendMaster")
    @Bean(name = "recommEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean recommendEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(recommendDataSource())
                .packages(RecommendationProperties.RECOMMENDATION_ENTITY_PATH)
                .build();
    }

    @Bean(name = "recommTransactionManager")
    public PlatformTransactionManager recommTransactionManager(
            final @Qualifier("recommEntityManagerFactory") LocalContainerEntityManagerFactoryBean recommEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(recommEntityManagerFactory.getObject()));
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return hibernateProperties;
    }

}
