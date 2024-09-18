package org.mind.toread.dto;

import lombok.Data;

import java.util.List;

@Data
public class NaverSearchRespDto {
    private int total;
    private List<BookDto> items;
}
