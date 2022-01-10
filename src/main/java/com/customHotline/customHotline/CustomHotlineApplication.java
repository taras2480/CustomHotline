package com.customHotline.customHotline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class CustomHotlineApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CustomHotlineApplication.class, args);


	}

}
