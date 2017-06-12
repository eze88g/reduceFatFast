package ar.com.reduceFatFast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReduceFatFastApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ReduceFatFastApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ReduceFatFastApplication.class, args);
	}
	
}
