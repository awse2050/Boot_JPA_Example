package com.example.bootex.domains.board;

import com.example.bootex.domains.board.entity.Board;

public class BoardEntitySetup {

    public Board getEntity() {
        int r = (int)( Math.random() * 30 + 1 );

        return  Board.builder()
                    .title("title"+r)
                    .content("content"+r)
                    .writer("writer"+r)
                    .build();
    }

}
