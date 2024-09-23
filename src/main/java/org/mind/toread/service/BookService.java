package org.mind.toread.service;

import lombok.RequiredArgsConstructor;
import org.mind.toread.dto.BookDto;
import org.mind.toread.dto.NaverSearchRespDto;
import org.mind.toread.mapper.BookMapper;
import org.mind.toread.model.Book;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor  // final 필드를 포함한 생성자를 자동 생성
public class BookService {

    private final NaverBookSearchService naverBookSearchService;
    private final BookMapper bookMapper;

    //책 검색
    public NaverSearchRespDto searchBook(String title) {
        NaverSearchRespDto serchResult = naverBookSearchService.searchBook(title);
        return serchResult;
    }

    //책 추가
    public void saveBook(BookDto saveReqBook) {
        Book saveBook = BookDto.toEntity(saveReqBook);
        bookMapper.saveBook(saveBook);

    }

    //책 전체 조회
    public void getBooks() {
        bookMapper.getBooks();
    }
}
