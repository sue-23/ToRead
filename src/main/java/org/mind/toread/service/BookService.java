package org.mind.toread.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mind.toread.dto.NaverSearchDto;
import org.mind.toread.dto.NaverSearchRespDto;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor  // final 필드를 포함한 생성자를 자동 생성
public class BookService {

    private final NaverBookSearchService naverBookSearchService;

    //책 검색
    public NaverSearchRespDto searchBook(String title) {
        NaverSearchRespDto bookInfo = naverBookSearchService.searchBook(title);
        return bookInfo;

    }

}
