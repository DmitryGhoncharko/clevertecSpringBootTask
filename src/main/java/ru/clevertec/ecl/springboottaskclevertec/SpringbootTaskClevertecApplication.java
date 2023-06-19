package ru.clevertec.ecl.springboottaskclevertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class SpringbootTaskClevertecApplication {
    //    @Autowired
//    private ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskClevertecApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//      Test test = (Test) applicationContext.getBean("test");
//        test.rs();
//    }
}
