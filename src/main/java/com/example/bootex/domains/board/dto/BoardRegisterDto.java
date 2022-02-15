package com.example.bootex.domains.board.dto;

import com.example.bootex.domains.board.entity.Board;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
// JSON 형식 중 null 필드 제외
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardRegisterDto {

    private Long id;

    private String title;

    private String content;

    private String writer;

    public static Board registerDtoToEntity(BoardRegisterDto dto) {
        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }
}
