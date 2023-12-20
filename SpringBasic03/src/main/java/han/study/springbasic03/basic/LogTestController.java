package han.study.springbasic03.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); //@Slf4j 어노테이션을 사용하면 바로 생성자 없이 호출 가능

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        log.debug("String concat log=" + name);
        return "OK";
    }

}
