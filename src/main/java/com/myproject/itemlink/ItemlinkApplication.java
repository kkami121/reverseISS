package com.myproject.itemlink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.myproject.itemlink.repository")
public class ItemlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemlinkApplication.class, args);
	}

}
