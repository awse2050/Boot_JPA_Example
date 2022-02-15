package com.example.bootex.domains.board.entity;

import com.example.bootex.util.DateEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Board extends DateEntity {

    // 게시물 번호, 제목, 내용, 작성자, 시간
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "TITLE", length = 20)
    private String title;

    @Lob // 제한없음.
    private String content;

    @Column(name = "WRITER")
    private String writer;
}
