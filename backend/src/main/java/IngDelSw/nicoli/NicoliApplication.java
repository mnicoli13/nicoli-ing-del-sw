package IngDelSw.nicoli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import IngDelSw.nicoli.model.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "IngDelSw.nicoli")
@EnableJpaRepositories(basePackages = "IngDelSw.nicoli.repository")
@EntityScan(basePackages = "IngDelSw.nicoli.model")
public class NicoliApplication {

	public static void main(String[] args) {
		SpringApplication.run(NicoliApplication.class, args);
	}

}
