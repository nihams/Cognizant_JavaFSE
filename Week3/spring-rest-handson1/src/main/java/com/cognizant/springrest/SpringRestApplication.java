package com.cognizant.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringRestApplication.class, args);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                (Country) context.getBean("country");

        System.out.println(country);
    }
}