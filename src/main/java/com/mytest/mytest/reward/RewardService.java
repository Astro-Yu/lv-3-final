package com.mytest.mytest.reward;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RewardService {

    public void addPoint() {
        log.info("\n[5] 포인트 적립!\n");
    }
}
