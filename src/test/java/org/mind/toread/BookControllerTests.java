package org.mind.toread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mind.toread.book.BookController;
import org.mind.toread.book.BookReqeust;
import org.mind.toread.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTests {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;


    @Test
    @DisplayName("책장에 책 저장")
    void insertBookTest() throws Exception {

        BookReqeust.SaveDto saveBook = new BookReqeust.SaveDto().builder()
                .title("개발자의 꿈")
                .image("test-image-url")
                .author("test-author")
                .description("test-description")
                .build();
        doNothing().when(bookService).saveBook(saveBook);
        mockMvc.perform(post("/bookshelf/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"개발자의 꿈\", \"image\":\"test-image-url\", \"author\":\"테스트 작가\", \"description\":\"테스트 설명\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$." +
                        "message").value("Book saved successfully"));

    }


    }

