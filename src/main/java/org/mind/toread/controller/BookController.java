package org.mind.toread.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mind.toread.dto.BookDto;
import org.mind.toread.dto.NaverSearchRespDto;
import org.mind.toread.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        log.info("컨트롤러에서 책 타이틀 가져오니?"+saveBookDto.getTitle());
        return new ResponseEntity<>("책장에 책 추가 완료", HttpStatus.CREATED);
    }



}
