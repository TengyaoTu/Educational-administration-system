package com.chinasoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chinasoft.mapper")
public class Shixun02Application {

	public static void main(String[] args) {
		SpringApplication.run(Shixun02Application.class, args);
	}

}
