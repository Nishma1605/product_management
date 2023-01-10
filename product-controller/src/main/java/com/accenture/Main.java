package com.accenture;

import com.accenture.Entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses=Product.class)
@EnableJpaRepositories("com.accenture")
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

}
