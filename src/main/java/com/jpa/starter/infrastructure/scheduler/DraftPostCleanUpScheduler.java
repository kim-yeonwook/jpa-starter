package com.jpa.starter.infrastructure.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DraftPostCleanUpScheduler {

    // 작성 완료 되지 않은 임시 게시글 삭제
    @Scheduled(cron = "0 0 3 * * ?")
    public void cleanUp() {

    }
}
