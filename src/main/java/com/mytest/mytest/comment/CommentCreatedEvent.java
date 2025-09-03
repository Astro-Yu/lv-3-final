package com.mytest.mytest.comment;

public record CommentCreatedEvent(
        Long commentId,
        String content
) {
}
