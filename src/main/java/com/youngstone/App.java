package com.youngstone;

import com.youngstone.hello.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {

        SpringApplication.run(App.class,args);

//        ApplicationContext applicationContext = SpringApplication.run(App.class,args);
//        for (String name : applicationContext.getBeanDefinitionNames()) {
//            System.out.println("Bean Name>>"+name);
//        }

    }
    @Profile("dev")
    @Bean
    public String devBean(){
        return "dev";
    }
    @Profile("qa")
    @Bean
    public String qaBean(){
        return "qa";
    }
    @Profile("prod")
    @Bean
    public String prodBean(){
        return "prod";
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(final RestTemplate restTemplate){
        return args -> {
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
