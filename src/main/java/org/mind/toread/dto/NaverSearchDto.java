package org.mind.toread.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NaverSearchDto {
    private String title;
    private String image;
    private String author;
    private String description;
}
