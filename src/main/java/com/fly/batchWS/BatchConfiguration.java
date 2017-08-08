package com.fly.batchWS;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.fly.batchWS.bean.WebService;
import com.fly.batchWS.mapper.WebServiceRowMapper;
import com.fly.batchWS.opperation.GetProp;
import com.fly.batchWS.processor.WebServiceProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;
    
    //tag::databaseconfiguration[]
    @Bean
    public DataSource dataSource(){
    	final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	    		
    	dataSource.setDriverClassName(GetProp.getProperty("db.DriverClassName", "config"));
    	dataSource.setUrl(GetProp.getProperty("db.UrlDataBase", "config"));
    	dataSource.setUsername(GetProp.getProperty("db.Username", "config"));
    	dataSource.setPassword(GetProp.getProperty("db.Password", "config"));
    	
    	return dataSource;
    }
    
    
    // tag::readerwriterprocessor[]
    @Bean
    public JdbcCursorItemReader<WebService> reader(){
    	JdbcCursorItemReader<WebService> reader = new JdbcCursorItemReader<>();
    	
    	reader.setDataSource(dataSource);
    	reader.setSql("SELECT * FROM swinfo, swurl WHERE swinfo.ID_WS = swurl.ID_WS");
    	reader.setRowMapper(new WebServiceRowMapper());
    	
    	return reader;
    }
    
    @Bean
    public WebServiceProcessor processor(){
    	return new WebServiceProcessor();
    }
    
 // tag::jobstep[]
    @Bean
    public Job importUserJob(){
    	return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
    
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<WebService, WebService> chunk(10)
                .reader(reader())
                .processor(processor())
                .build();
    }
    // end::jobstep[]
}
