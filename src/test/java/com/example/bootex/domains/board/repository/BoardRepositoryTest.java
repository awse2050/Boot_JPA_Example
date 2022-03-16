package com.example.bootex.domains.board.repository;

import com.example.bootex.domains.board.BoardEntitySetup;
import com.example.bootex.domains.board.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName(" [Board Repository Tests] ")
@SpringBootTest
@Transactional
@Commit
class BoardRepositoryTest extends BoardEntitySetup {

    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    public void before() {
        Board board = getEntity();

        boardRepository.save(board);
    }

    @Test
    @DisplayName("Save Test 성공")
    public void SAVE_SUCCESS_TEST() {

        Board board = getEntity();

        boardRepository.save(board);

        assertThat(board.getId()).isNotNull();

    }

    @Test
    @DisplayName("게시물 1개 조회 성공")
    public void FIND_SUCCESS_TEST() {

        Long id = 1L;

        Board board = boardRepository.findById(id);

        assertThat(board).isNotNull();

    }

    @Test
    @DisplayName("전체 게시물조회")
    public void FIND_ALL_SUCCESS_TEST() {
        List<Board> list = boardRepository.findAll();

        assertThat(list.size()).isGreaterThan(0);
    }

}