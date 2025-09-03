package com.mytest.mytest.reward;

import com.mytest.mytest.comment.CommentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class RewardEventListener {

    private final RewardService rewardService;

    // 여기서 이벤트를 받고 리워드 관련 로직 실행
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCommentCreatedEvent(CommentCreatedEvent event) {
        rewardService.addPoint();
    }
}
