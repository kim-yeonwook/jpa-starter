package com.jpa.starter.infrastructure.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 매일 3시 DELETE 상태가 3개월이 지속된 경우 삭제
 */
@RequiredArgsConstructor
@Component
public class DeletedStatusTaskCleanUpScheduler {

    @Scheduled(cron = "0 0 3 * * ?")
    public void cleanUpBoard() {

    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void cleanUpPost() {
        
    }
}
