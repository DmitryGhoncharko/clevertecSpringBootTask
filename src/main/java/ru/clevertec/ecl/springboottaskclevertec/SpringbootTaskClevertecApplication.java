package ru.clevertec.ecl.springboottaskclevertec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.clevertec.ecl.springboottaskclevertec.repository.Test;

@SpringBootApplication
public class SpringbootTaskClevertecApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskClevertecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Test test = (Test) applicationContext.getBean("test");
        test.find();
    }
}
