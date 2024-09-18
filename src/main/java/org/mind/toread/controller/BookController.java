package org.mind.toread.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mind.toread.dto.BookDto;
import org.mind.toread.dto.NaverSearchRespDto;
import org.mind.toread.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BookController {

    private final BookService bookService;

    @GetMapping("/bookshelf/search")
    public ResponseEntity<NaverSearchRespDto> searchBook(@RequestParam String title) {
        NaverSearchRespDto searchBookList = bookService.searchBook(title);
        return ResponseEntity.ok(searchBookList);
    }

    @PostMapping("/bookshelf/add")
    public ResponseEntity<?> saveBook(@RequestBody BookDto saveBookDto) {
        bookService.saveBook(saveBookDto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Book saved successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}
