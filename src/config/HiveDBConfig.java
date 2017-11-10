package config;


import hivebase.HiveDataSource;
import hivebase.HiveDatabaseIdProvider;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by shiquan on 16/7/16.
 */

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "datasource.hivelive")
@MapperScan(basePackages = HiveDBConfig.PACKAGE, sqlSessionFactoryRef = "hiveLiveSqlSessionFactory")
public class HiveDBConfig {
    static final String PACKAGE = "com.ksyun.tiantian.dao.hive";

    @Bean(name = "hiveLiveDataSource")
    public DataSource rdsDataSource() {
        System.out.println("---------------------- DashBoardDBConfig ------------------------");
        DataSource ds = new HiveDataSource("jdbc:hive2://10.69.41.195:10000/default", "root", "default");
        return ds;

    }

    @Bean(name = "hiveLiveSqlSessionFactory")
    public SqlSessionFactory rdsSqlSessionFactory(@Qualifier("hiveLiveDataSource") DataSource hivedatasource) throws Exception {
        System.out.println("---------------------- DashBoardDBConfig rdsSqlSessionFactory ------------------------");
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hivedatasource);
        sessionFactory.setDatabaseIdProvider(new HiveDatabaseIdProvider());

        return sessionFactory.getObject();
    }
}