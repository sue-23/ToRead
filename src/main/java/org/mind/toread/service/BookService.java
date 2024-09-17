package org.mind.toread.service;

import lombok.RequiredArgsConstructor;
import org.mind.toread.dto.NaverSearchRespDto;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor  // final 필드를 포함한 생성자를 자동 생성
public class BookService {

    private final NaverBookSearchService naverBookSearchService;

    //책 검색
    public NaverSearchRespDto searchBook(String title) {
        NaverSearchRespDto serchResult = naverBookSearchService.searchBook(title);
        return serchResult;
    }

}
