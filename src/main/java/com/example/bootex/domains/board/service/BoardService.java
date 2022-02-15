package com.example.bootex.domains.board.service;

import com.example.bootex.domains.board.entity.Board;
import com.example.bootex.domains.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 성능향상
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시판 등록
     * @param board
     * @return boardId
     */
    @Transactional
    public Long register(Board board) {
        // 영속상태로 선언
        boardRepository.save(board);
        Long boardId = board.getId();

        return boardId;
    }
}
