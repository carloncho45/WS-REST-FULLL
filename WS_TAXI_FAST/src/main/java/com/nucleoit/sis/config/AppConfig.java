package com.nucleoit.sis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.nucleoit.sis" })
public class AppConfig {

//	
//	  <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//      <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
//      <property name="url" value="jdbc:oracle:thin:@192.168.1.100:1521:orcl"/>
//      <property name="username" value="user1"/>
//      <property name="password" value="admin"/>
//  </bean>
	
//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//	    driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	    driverManagerDataSource.setUrl("jdbc:oracle:thin:@192.168.1.100:1521:orcl");
//	    driverManagerDataSource.setUsername("user1");
//	    driverManagerDataSource.setPassword("admin");
//	    return driverManagerDataSource;
//	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}