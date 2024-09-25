package org.mind.toread.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor  // final 필드를 포함한 생성자를 자동 생성
public class BookService {

    private final NaverBookSearchService naverBookSearchService;
    private final BookMapper bookMapper;

    //책 검색
    public BookResponse.NaverSearchDto searchBook(String title) {
        BookResponse.NaverSearchDto serchResult = naverBookSearchService.searchBook(title);
        return serchResult;
    }

    //책 추가
    public void saveBook(BookReqeust.SaveDto saveReqBook) {
        Book saveBook = BookReqeust.SaveDto.toEntity(saveReqBook);
        bookMapper.saveBook(saveBook);

    }

    //책 전체 조회
    public void getBooks() {
        bookMapper.getBooks();
    }
}
