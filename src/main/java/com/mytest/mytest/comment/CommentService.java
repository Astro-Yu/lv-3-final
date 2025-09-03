package com.mytest.mytest.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void addComment() {
        Comment commentWithoutId = new Comment("ㅋㅋ");
        Comment savedMoment = commentRepository.save(commentWithoutId);

        // 이벤트 발행
        // comment 저장이 성공적으로 커밋되면 이벤트가 리스너에게 전파됨
        eventPublisher.publishEvent(new CommentCreatedEvent(savedMoment.getId(), savedMoment.getContent()));
    }
}
