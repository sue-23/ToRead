package org.mind.toread;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "org.mind.toread.mapper")
public class ToReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToReadApplication.class, args);
    }

}
