package org.mind.toread.model;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Book {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String descriptioin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isRead;
    private Long userId;
    private Long categoryId;

}
