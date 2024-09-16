
### 1. 개요

Java와 Spring Boot를 사용하여 도서 관리 시스템 개발. SQL, Java, SpringBoot, TDD 습관 형성 목표. MyBatis와 MariaDB를 활용한 데이터베이스 연동 및 API 설계 학습.

### 2. 기능

- **1. 책 전체 목록 조회(읽음/미읽음)**
    - 카테고리별 조회
    - 등록기준일 기준 최신순 정렬
    - 수정기준일 기준 최신순 정렬
- **2. 책 단건 조회**
    - 책 감상평 작성
    - 책 감상평 수정
    - 책 감상평 삭제
- **3. 책 등록**
    - 네이버 책 API 연동: 책 표지, 제목, 작성자, 카테고리 자동 등록
    - 추가 정보 수동 입력 가능
- **4. 책 수정**
    - 책 표지, 제목, 작성자, 카테고리 수정
- **5. 책 삭제**
- **6. 책 검색**
    - 제목, 작성자, 카테고리, 출판 연도 등 다양한 조건으로 검색 가능
- **7. 책 읽음 표시**
- **8. 카테고리 추가**
- **9. 회원가입/로그인**

### 3. DB
USERS 테이블

|Column|Type|Constraints|
|---|---|---|
|id|BIGINT|AUTO_INCREMENT, PRIMARY KEY|
|username|VARCHAR(255)|NOT NULL|
|password|VARCHAR(255)|NOT NULL|
|nickname|VARCHAR(255)||
|profile_img|VARCHAR(255)||

#### CATEGORY 테이블

|Column|Type|Constraints|
|---|---|---|
|id|BIGINT|AUTO_INCREMENT, PRIMARY KEY|
|name|VARCHAR(255)|NOT NULL|

#### BOOK 테이블

|Column|Type|Constraints|
|---|---|---|
|id|BIGINT|AUTO_INCREMENT, PRIMARY KEY|
|title|VARCHAR(255)|NOT NULL|
|image|VARCHAR(255)||
|author|VARCHAR(255)|NOT NULL|
|description|TEXT||
|created_at|DATE|NOT NULL|
|updated_at|DATE||
|is_read|BOOLEAN|DEFAULT FALSE|
|user_id|BIGINT|FOREIGN KEY, REFERENCES USERS(id)|
|category_id|BIGINT|NOT NULL, FOREIGN KEY, REFERENCES CATEGORY(id)|

#### REVIEW 테이블

| Column     | Type         | Constraints                       |
| ---------- | ------------ | --------------------------------- |
| id         | BIGINT       | AUTO_INCREMENT, PRIMARY KEY       |
| title      | VARCHAR(255) | NOT NULL                          |
| comment    | TEXT         |                                   |
| created_at | DATE         | NOT NULL                          |
| updated_at | DATE         |                                   |
| user_id    | BIGINT       | FOREIGN KEY, REFERENCES USERS(id) |
| book_id    | BIGINT       | FOREIGN KEY, REFERENCES BOOK(id)  |