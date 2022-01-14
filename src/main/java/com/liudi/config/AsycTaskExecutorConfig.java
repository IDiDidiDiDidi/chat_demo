package com.liudi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置、启用异步
 *
 */
//开启异步
@EnableAsync(proxyTargetClass = true)
@Configuration
public class AsycTaskExecutorConfig {

    @Value("${task.queue.corePoolSize}")
    private int corePoolSize;//线程池维护线程的最少数量
    @Value("${task.queue.maxPoolSize}")
    private int maxPoolSize;//线程池维护线程的最大数量
    @Value("${task.queue.queueCapacity}")
    private int queueCapacity; //缓存队列
    @Value("${task.queue.keepAlive}")
    private int keepAlive;//允许的空闲时间

    @Bean("taskQueueExecutor")
    public Executor taskQueueExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(queueCapacity);
        // 设置默认线程名称
        executor.setThreadNamePrefix("taskQueueExecutor-");
        //对拒绝task的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAlive);
        executor.initialize();
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}