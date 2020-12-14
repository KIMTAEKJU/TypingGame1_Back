package com.config.java;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value="com.mybatis.mappers")
@ComponentScan(value= {"com.service", "com.dao"})
// AppConfig가 DBConfig MabatisConfig를 합쳐서 import 하고있기떄문에 DBConfig를 import 할필요없다
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		sqlSessionFactoryBean.setDataSource(dataSource);

		// String이 아니기때문에 resource로 전달
		// applicationContext에 getResource가 있어서 그걸로 가져와야함
//		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:com/config/app/mybatis/configuration.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/config/app/mybatis/mappers/*.xml"));

		return sqlSessionFactoryBean.getObject(); // getObject를 해야 가져올수있다
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
