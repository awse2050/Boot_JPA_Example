package com.example.bootex.domains.board.service;

import com.example.bootex.domains.board.BoardDtoSetup;
import com.example.bootex.domains.board.dto.BoardGetDto;
import com.example.bootex.domains.board.dto.BoardRegisterDto;
import com.example.bootex.domains.board.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
@DisplayName(" [ Board Query Service Tests ] ")
class BoardQueryServiceTest extends BoardDtoSetup {

    @Autowired
    private BoardQueryService boardQueryService;

    @Autowired
    private BoardCommandService boardCommandService;

    @BeforeEach
    public void before() {
        BoardRegisterDto dto = getRegisterDto();

        Long id = boardCommandService.register(dto);
    }

    @DisplayName("게시물 1개 조회 성공")
    @Test
    public void GET_BOARD_SUCCESS_TEST() {

        Long id = 1L;

        BoardGetDto dto = boardQueryService.getBoardById(id);

        assertThat(dto).isNotNull();
    }

    @DisplayName("게시물 전체 조회 성공")
    @Test
    public void FIND_ALL_SUCCESS_TEST() {

        List<BoardGetDto> dtoList = boardQueryService.getAllBoard();

        assertThat(dtoList.size()).isGreaterThan(0);
    }

}