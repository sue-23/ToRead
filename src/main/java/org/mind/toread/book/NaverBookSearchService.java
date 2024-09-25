package org.mind.toread.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@RequiredArgsConstructor
public class NaverBookSearchService {

    @Value("${X-Naver-Client-Id}")
    private String clientId;

    @Value("${X-Naver-Client-Secret}")
    private String secretKey;

    @Value("${NAVER_API_URL}")
    private String apiUrl;


    public BookResponse.NaverSearchDto searchBook(String title) {

        String searchUrl = apiUrl + title;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", secretKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<BookResponse.NaverSearchDto> response  = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, BookResponse.NaverSearchDto.class);

        return response.getBody();

    }




}
