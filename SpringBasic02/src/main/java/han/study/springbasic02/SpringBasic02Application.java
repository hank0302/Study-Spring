package han.study.springbasic02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBasic02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasic02Application.class, args);
    }

}
