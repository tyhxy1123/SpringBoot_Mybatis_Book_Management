package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {

//        SpringApplication.run(SSMPApplication.class, args);

        // Program args werden dadurch verborgen, console args werden nicht wahrgenommen
        SpringApplication.run(SSMPApplication.class);
    }

}
