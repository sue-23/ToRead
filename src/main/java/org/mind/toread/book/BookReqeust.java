package org.mind.toread.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BookReqeust {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SaveDto {
        private String title;
        private String image;
        private String author;
        private String description;

        public static Book toEntity(SaveDto saveDto) {
            return Book.builder()
                    .title(saveDto.title)
                    .image(saveDto.image)
                    .author(saveDto.author)
                    .description(saveDto.description)
                    .build();
        }


    }
}
