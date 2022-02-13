package org.richard.demorestjpa;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(CustomerRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(
					new Customer("Kevin", "Bridges", LocalDate.of(1980, Month.JANUARY, 5), "kevin.bridges@gmail.com")));
			log.info("Preloading " + repository.save(
					new Customer("Harriet", "Harman", LocalDate.of(1985, Month.NOVEMBER, 24), "harriet.harman@gmail.com")));
		};
	}

}
