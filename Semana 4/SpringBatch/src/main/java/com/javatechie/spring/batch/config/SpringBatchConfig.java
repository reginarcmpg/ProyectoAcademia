package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.bookEntity;
import com.javatechie.spring.batch.repository.bookrepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import java.util.function.Supplier;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private bookrepository customerRepository;


    @Bean
    public FlatFileItemReader<bookEntity> reader() {//Bring the csv to the code
        FlatFileItemReader<bookEntity> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/books_list.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<bookEntity> lineMapper() { //mapped
        DefaultLineMapper<bookEntity> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "tilte", "author", "year", "category", "languaje", "originCountry");

        BeanWrapperFieldSetMapper<bookEntity> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(bookEntity.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public Step step1() {
    	
       	Supplier<RepositoryItemWriter<bookEntity>> supplier = () -> {
			RepositoryItemWriter<bookEntity> writer = new RepositoryItemWriter<>();
	        writer.setRepository(customerRepository);
	        writer.setMethodName("save");
	        return writer;
       	};
    	
        return stepBuilderFactory.get("csv-step")
        		.<bookEntity, bookEntity>chunk(10)
                .reader(reader())
                .processor((ItemProcessor<bookEntity, bookEntity>) cliente -> {
                	if(cliente.getLanguaje().equals("French"))
                        return cliente;
                    return null;
                })
                .writer(supplier.get())
                .taskExecutor(taskExecutor())
                .build();
    }
    
    @Bean
    public Job runJob() { //import csv
        return jobBuilderFactory
        		.get("importBooks")
        		.flow(step1())
        		.end()
        		.build();
 

    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
