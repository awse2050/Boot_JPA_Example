package com.example.bootex.domains.board.repository;

import com.example.bootex.domains.board.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;

@DisplayName(" [Board Repository Tests] ")
@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("Save Test 성공")
    @Commit
    public void SAVE_SUCCESS_TEST() {

        Board board = Board.builder()
                .title("title2")
                .content("content2")
                .writer("writer3")
                .build();

        boardRepository.save(board);

        assertThat(board.getId()).isNotNull();

    }

}