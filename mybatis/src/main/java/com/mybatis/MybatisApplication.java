package com.mybatis;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MybatisApplication {

	public static void main(String[] args) throws SchedulerException {

		SpringApplication.run(MybatisApplication.class, args);

	}

}
