package junseok.snr.web.lb.client;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class ServerConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new ServerServiceInstanceListSupplier("server");
    }
}

@RequiredArgsConstructor
class ServerServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    public static final String LOCALHOST = "localhost";
    private final String serviceId;

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(
                Arrays.asList(
                        new DefaultServiceInstance(serviceId + "1", serviceId, LOCALHOST, 65002, false),
                        new DefaultServiceInstance(serviceId + "2", serviceId, LOCALHOST, 65003, false),
                        new DefaultServiceInstance(serviceId + "3", serviceId, LOCALHOST, 65004, false)
                )
        );
    }
}
