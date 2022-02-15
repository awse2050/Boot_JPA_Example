package com.example.bootex.domains.board.dto;

import com.example.bootex.domains.board.entity.Board;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
// JSON 형식 중 null 필드 제외
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardGetDto {

    private Long id;

    private String title;
    private String content;
    private String writer;

    private LocalDateTime regdate;
    private LocalDateTime moddate;

    public static BoardGetDto entityToGetDto(Board board) {
        return BoardGetDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .regdate(board.getRegDate())
                .moddate(board.getModDate())
                .build();
    }

    public static List<BoardGetDto> convertToDtoList(List<Board> boards) {
        return boards.stream()
                .map(board -> entityToGetDto(board))
                .collect(Collectors.toList());
    }

}
