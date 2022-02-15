package com.example.bootex.domains.board;

import com.example.bootex.domains.board.dto.BoardGetDto;
import com.example.bootex.domains.board.dto.BoardRegisterDto;
import com.example.bootex.domains.board.entity.Board;

public class BoardDtoSetup {

    public BoardRegisterDto getRegisterDto() {
        int r = (int)( Math.random() * 30 + 1 );

        return BoardRegisterDto
                .builder()
                .title("title"+r)
                .content("content"+r)
                .writer("writer"+r)
                .build();
    }

    public BoardGetDto getSelectDto(Board board) {
        return BoardGetDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .regdate(board.getRegDate())
                .moddate(board.getModDate())
                .build();
    }

}
