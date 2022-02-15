package com.example.bootex.domains.board.service;

import com.example.bootex.domains.board.dto.BoardRegisterDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
@DisplayName(" [ Board Service Tests ] ")
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @DisplayName("Register Test")
    @Test
    public void REGISTER_SUCCESS_TEST() {

        BoardRegisterDto dto = BoardRegisterDto
                .builder()
                .title("title3")
                .content("content3")
                .writer("writer3")
                .build();

        Long id = boardService.register(dto);

        assertThat(id).isNotNull();
    }
}