package com.example.bootex.domains.board.service;

import com.example.bootex.domains.board.BoardDtoSetup;
import com.example.bootex.domains.board.dto.BoardRegisterDto;
import org.junit.jupiter.api.BeforeEach;
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
@DisplayName(" [ Board Command Service Tests ] ")
class BoardCommandServiceTest extends BoardDtoSetup {

    @Autowired
    private BoardCommandService boardCommandService;

    @BeforeEach
    public void before() {
        BoardRegisterDto dto = getRegisterDto();

        Long id = boardCommandService.register(dto);
    }

    @DisplayName("Register Test")
    @Test
    public void REGISTER_SUCCESS_TEST() {

        BoardRegisterDto dto = getRegisterDto();

        Long id = boardCommandService.register(dto);

        assertThat(id).isNotNull();
    }
}