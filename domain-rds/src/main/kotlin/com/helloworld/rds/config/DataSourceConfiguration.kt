package com.helloworld.rds.config

import com.helloworld.coupon.domain.entity.Coupon
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.sql.DataSource


@Configuration(proxyBeanMethods = false)
class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties("app.datasource.first")
    fun firstDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first.configuration")
    fun firstDataSource(firstDataSourceProperties: DataSourceProperties): HikariDataSource {
        return firstDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
    }

    @Bean
    @ConfigurationProperties("app.datasource.second")
    fun secondDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("app.datasource.second.configuration")
    fun secondDataSource(firstDataSourceProperties: DataSourceProperties): HikariDataSource {
        return firstDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.jpa.first")
    fun firstJpaProperties(): JpaProperties? {
        return JpaProperties()
    }

    @Bean
    @ConfigurationProperties("app.jpa.second")
    fun secondJpaProperties(): JpaProperties? {
        return JpaProperties()
    }

    @Bean
    @Primary
    fun firstEntityManagerFactory(
        firstDataSource: DataSource,
        firstJpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        val builder: EntityManagerFactoryBuilder = createEntityManagerFactoryBuilder(firstJpaProperties)
        return builder.dataSource(firstDataSource).packages(Coupon::class.java).persistenceUnit("firstDs").build()
    }

    @Bean
    fun secondEntityManagerFactory(
        secondDataSource: DataSource,
        secondJpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        val builder: EntityManagerFactoryBuilder = createEntityManagerFactoryBuilder(secondJpaProperties)
        return builder.dataSource(secondDataSource).packages(Coupon::class.java).persistenceUnit("secondDs").build()
    }

    private fun createEntityManagerFactoryBuilder(jpaProperties: JpaProperties): EntityManagerFactoryBuilder {
        val jpaVendorAdapter = createJpaVendorAdapter(jpaProperties)
        return EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.properties, null)
    }

    private fun createJpaVendorAdapter(jpaProperties: JpaProperties): JpaVendorAdapter {
        // ... map JPA properties as needed
        return HibernateJpaVendorAdapter()
    }
}
