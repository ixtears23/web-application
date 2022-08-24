package junseok.snr.web.lb.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lb/client")
@RestController
public class LBClientController {

    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @GetMapping
    public String member(@RequestParam(value = "name", defaultValue = "junseok") String name) {

        final String responseBody = loadBalancedWebClientBuilder.build()
                .get().uri("http://server/lb/server")
                .retrieve()
                .bodyToMono(String.class)
                .map(resposne -> String.format("%s, %s!", resposne, name))
                .block();

        log.info("====== ResponseBody : {}", responseBody);

        return responseBody;
    }


    @PostMapping
    public Mono<String> employee(@RequestParam(value = "name", defaultValue = "js") String name) {
        final Mono<String> responseBody = WebClient.builder()
                .filter(lbFunction)
                .build()
                .get().uri("http://server/lb/server")
                .retrieve()
                .bodyToMono(String.class)
                .map(resposne -> String.format("%s, %s!", resposne, name));

        log.info("====== ResponseBody : {}", responseBody);

        return responseBody;
    }

}
