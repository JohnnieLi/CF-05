package ca.ucareer.computerfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
//hello
public class ComputerfactoryApplication {

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-4:00"));
	}

	public static void main(String[] args) {

		SpringApplication.run(ComputerfactoryApplication.class, args);
	}

}
