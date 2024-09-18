package org.mind.toread.dto;


import lombok.Builder;
import lombok.Data;
import org.mind.toread.model.Book;

@Data
@Builder
public class BookDto {
    private String title;
    private String image;
    private String author;
    private String description;

    public static Book toEntity(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.title)
                .image(bookDto.image)
                .author(bookDto.author)
                .description(bookDto.description)
                .build();
    }


}
