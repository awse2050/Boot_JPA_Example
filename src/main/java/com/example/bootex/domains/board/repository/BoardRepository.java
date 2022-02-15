package com.example.bootex.domains.board.repository;

import com.example.bootex.domains.board.entity.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }

    public Board findById(Long id) {
        return em.find(Board.class, id);
    }

    // TODO : 삭제기능은 필요할 때만 구현한다.
    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    public List<Board> findAll() {
        return em.createQuery("SELECT b FROM Board b WHERE b.id > 0")
                .getResultList();
    }
}
