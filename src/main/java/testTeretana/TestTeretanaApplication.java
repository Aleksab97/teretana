package testTeretana;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableJSONDoc
@EnableSwagger2
@SpringBootApplication
public class TestTeretanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTeretanaApplication.class, args);
	}

}

