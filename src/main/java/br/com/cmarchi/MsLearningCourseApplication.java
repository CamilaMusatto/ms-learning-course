package br.com.cmarchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class MsLearningCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLearningCourseApplication.class, args);
	}

}
