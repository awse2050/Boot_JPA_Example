package com.example.bootex.domains.board.service;

import com.example.bootex.domains.board.dto.BoardGetDto;
import com.example.bootex.domains.board.entity.Board;
import com.example.bootex.domains.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardQueryService {

    private final BoardRepository boardRepository;

    /**
     * 게시물 조회
     * @param id
     * @return
     */
    public BoardGetDto getBoardById(Long id) {
        BoardGetDto dto = BoardGetDto.entityToGetDto(boardRepository.findById(id));
        return dto;
    }

    /**
     * 게시물 전체 조회
     * @return
     */
    public List<BoardGetDto> getAllBoard() {
        return BoardGetDto.convertToDtoList(boardRepository.findAll());
    }

}
