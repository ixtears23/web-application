package junseok.snr.web.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskComponent {

    @Async("asyncTaskExecutor")
    public void async() throws Exception {
        log.info("==========async()");
        log.info("========== start - currentThread : {}", Thread.currentThread().getName());
        Thread.sleep(3000);
        log.info("========== end - currentThread : {}", Thread.currentThread().getName());
    }

    public void sync() throws Exception {
        log.info("==========sync()");
        log.info("========== start - currentThread : {}", Thread.currentThread().getName());
        Thread.sleep(3000);
        log.info("========== end - currentThread : {}", Thread.currentThread().getName());
    }
}
