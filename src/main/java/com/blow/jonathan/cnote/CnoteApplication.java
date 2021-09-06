package com.blow.jonathan.cnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.blow.jonathan.cnote")
public class CnoteApplication {
	public static void main(String[] args) {
		SpringApplication.run(CnoteApplication.class, args);
	}
}
