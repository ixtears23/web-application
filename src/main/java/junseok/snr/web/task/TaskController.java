package junseok.snr.web.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/task")
@RestController
public class TaskController {

    private final TaskComponent taskComponent;

    @PostMapping("/async")
    @ResponseStatus(code = HttpStatus.OK)
    public void asyncTask() throws Exception {
        log.info("========== START - simpleTest()");
        for (int i = 0; i < 1000000; i++) taskComponent.async();
        log.info("========== END - simpleTest()");
    }


    @PostMapping("/sync")
    @ResponseStatus(code = HttpStatus.OK)
    public void syncTask() throws Exception {
        log.info("========== START - simpleTest()");
        for (int i = 0; i < 1000000; i++) taskComponent.sync();
        log.info("========== END - simpleTest()");
    }
}
