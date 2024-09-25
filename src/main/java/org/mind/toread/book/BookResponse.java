package org.mind.toread.book;

import lombok.Data;

import java.util.List;

public class BookResponse {
    @Data
    public static class NaverSearchDto {
        private int total;
        private List<BookReqeust.SaveDto> items;
    }
}
