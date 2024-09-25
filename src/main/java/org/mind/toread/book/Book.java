package org.mind.toread.book;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
public class Book {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isRead;
    private Long userId;
    private Long categoryId;

}
