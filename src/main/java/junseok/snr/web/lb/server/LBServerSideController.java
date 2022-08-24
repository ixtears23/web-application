package junseok.snr.web.lb.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/lb/server")
@RestController
public class LBServerSideController {

    @Value("${server.instance.id}")
    private String instanceId;

    @GetMapping
    public String findName() {
        final String info = "===== Server Instance " + instanceId;
        log.info(info);
        return info;
    }

}
