package com.vyas.hemant.SpringPostGreExamle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPostGreExamleApplication implements CommandLineRunner {

	@Autowired
    private BookRespository repository;
	private static final Logger log = LoggerFactory.getLogger(SpringPostGreExamleApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(SpringPostGreExamleApplication.class, args);
	}

	
	@Override
    public void run(String... args) {

        log.info("StartApplication...");

        repository.save(new Book("RHAMT"));
        repository.save(new Book("OpenShift"));
        repository.save(new Book("SpringBoot"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));

    }
	
}
