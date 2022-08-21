package junseok.snr.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("asyncTaskExecutor")
    public TaskExecutor threadPoolExecutor() {
        return createThreadPoolTaskExecutor();
    }

    private TaskExecutor createThreadPoolTaskExecutor() {
        final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1000);
        taskExecutor.setMaxPoolSize(2000);
        taskExecutor.setQueueCapacity(10);
        taskExecutor.setThreadNamePrefix("***executor - ");
        taskExecutor.setRejectedExecutionHandler(Rejec);
        return taskExecutor;
    }

}
