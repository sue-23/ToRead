package org.mind.toread.controller;

import lombok.RequiredArgsConstructor;
import org.mind.toread.dto.NaverSearchRespDto;
import org.mind.toread.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("book/search")
    public ResponseEntity<NaverSearchRespDto> searchBook(@RequestParam String title) {

        NaverSearchRespDto serchResult = bookService.searchBook(title);
        return ResponseEntity.ok(serchResult);

    }


}
