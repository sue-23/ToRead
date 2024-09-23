package org.mind.toread.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.mind.toread.dto.BookDto;
import org.mind.toread.model.Book;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookMapper {

    //ToRead 에 Book 추가
    void saveBook(Book saveReqBook);

    // 전체 BookList 불러오기
    Book getBooks();
}
