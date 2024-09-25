package org.mind.toread.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BookController {

    private final BookService bookService;

    @GetMapping("/bookshelf/search")
    public ResponseEntity<BookResponse.NaverSearchDto> searchBook(@RequestParam String title) {
        BookResponse.NaverSearchDto searchBookList = bookService.searchBook(title);
        return ResponseEntity.ok(searchBookList);
    }

    @PostMapping("/bookshelf/add")
    public ResponseEntity<?> saveBook(@RequestBody BookReqeust.SaveDto saveBookDto) {
        bookService.saveBook(saveBookDto);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Book saved successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @GetMapping("bookshelf/list")
//    public ResponseEntity<?> getBooks() {
//
//        bookService.getBooks();
//
//        return ResponseEntity.status(HttpStatus.OK).body();
//    }
}
