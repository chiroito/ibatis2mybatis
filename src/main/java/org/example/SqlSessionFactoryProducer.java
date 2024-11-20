package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.cdi.SessionFactoryProvider;

import java.io.IOException;
import java.io.InputStream;

@Dependent
public class SqlSessionFactoryProducer {

    @Produces
    @ApplicationScoped
    @SessionFactoryProvider
    public SqlSessionFactory produceFactory() throws IOException {
        InputStream fileStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fileStream);
        return sqlSessionFactory;
    }
}
