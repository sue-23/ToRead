-- USERS 테이블
CREATE TABLE IF NOT EXISTS USERS (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(255),
    profile_img VARCHAR(255)
    );

-- CATEGORY 테이블
CREATE TABLE IF NOT EXISTS CATEGORY (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
    );

-- BOOK 테이블
CREATE TABLE IF NOT EXISTS BOOK (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    title VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    author VARCHAR(255) NOT NULL,
    description TEXT,
    created_at DATE NOT NULL,
    updated_at DATE,
    is_read BOOLEAN DEFAULT FALSE,
    user_id BIGINT,
    category_id BIGINT NOT NULL,
    CONSTRAINT FK_USER_BOOK FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE,
    CONSTRAINT FK_CATEGORY_BOOK FOREIGN KEY (category_id) REFERENCES CATEGORY(id) ON DELETE CASCADE
    );

-- REVIEW 테이블
CREATE TABLE IF NOT EXISTS REVIEW (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      title VARCHAR(255) NOT NULL,
    comment TEXT,
    created_at DATE NOT NULL,
    updated_at DATE,
    user_id BIGINT,
    book_id BIGINT,
    CONSTRAINT FK_USER_REVIEW FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE,
    CONSTRAINT FK_BOOK_REVIEW FOREIGN KEY (book_id) REFERENCES BOOK(id) ON DELETE CASCADE
    );
