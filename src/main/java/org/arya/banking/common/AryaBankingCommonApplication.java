package org.arya.banking.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class AryaBankingCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AryaBankingCommonApplication.class, args);
    }

}
