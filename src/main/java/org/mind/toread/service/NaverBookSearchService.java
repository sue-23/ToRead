package org.mind.toread.service;

import lombok.extern.log4j.Log4j2;
import org.mind.toread.dto.NaverSearchDto;
import org.mind.toread.dto.NaverSearchRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Log4j2
public class NaverBookSearchService {

    @Value("${X-Naver-Client-Id}")
    private String clientId;

    @Value("${X-Naver-Client-Secret}")
    private String secretKey;

    @Value("${NAVER_API_URL}")
    private String apiUrl;


    public NaverSearchRespDto searchBook(String title) {

        String searchUrl = apiUrl + "?query=" + title;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", secretKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NaverSearchRespDto> response  = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, NaverSearchRespDto.class);


        return response.getBody();


    }




}
