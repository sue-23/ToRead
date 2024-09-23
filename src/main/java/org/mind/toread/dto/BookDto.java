package org.mind.toread.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mind.toread.model.Book;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public static void toDto(Book book) {

        BookDto toDto = BookDto.builder()
                .title(book.getTitle())
                .image(book.getImage())
                .author(book.getAuthor())
                .description(book.getDescription())
                .build();
    }



}
