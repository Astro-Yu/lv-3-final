package com.mytest.mytest.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    public void sendNotification(String content) {
        log.info("\n [{}] 라는 코멘트 도착! \n", content);
    }
}
