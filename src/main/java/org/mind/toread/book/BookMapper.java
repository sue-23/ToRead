package org.mind.toread.book;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookMapper {

    //ToRead 에 Book 추가
    void saveBook(Book saveReqBook);

    // 전체 BookList 불러오기
    Book getBooks();
}
