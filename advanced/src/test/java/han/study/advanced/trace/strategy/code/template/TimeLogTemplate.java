package han.study.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        callback.call();
        long endTIme = System.currentTimeMillis();
        long resultTime = endTIme - startTime;
        log.info("resultTime={}", resultTime);
    }
}
