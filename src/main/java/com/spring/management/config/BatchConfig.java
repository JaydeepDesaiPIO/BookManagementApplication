package com.spring.management.config;

import com.spring.management.model.Books;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcCursorItemReader<Books> reader(){
        JdbcCursorItemReader<Books> reader=new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("select * from books");
        reader.setRowMapper(new RowMapper<Books>() {
            @Override
            public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
                Books b=new Books();
                b.setId(rs.getInt("book_id"));
                b.setAuthor(rs.getString("author"));
                b.setBookName(rs.getString("book_name"));
                return b;
            }
        });
        return reader;
    }

    @Bean
    public FlatFileItemWriter<Books> writer(){
        FlatFileItemWriter<Books> writer=new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("csv_output.csv"));
        DelimitedLineAggregator<Books> aggregator= new DelimitedLineAggregator<>();
        BeanWrapperFieldExtractor<Books> fieldExtractor=new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[] {"id","author","bookName"});
        aggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(aggregator);
        return writer;
    }

    @Bean
    public Step step()
    {
        return stepBuilderFactory.get("step").<Books,Books>chunk(5)
                .reader(reader())
                .writer(writer())
                .build();
    }

    @Bean
    public Job generateCSVReportCard() {
        return jobBuilderFactory
                .get("generateReportCard")
                .incrementer(new RunIdIncrementer())
                .flow(step()).end().build();

    }
}
