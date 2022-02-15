package com.example.bootex.listener;

import lombok.extern.log4j.Log4j2;

import javax.persistence.PrePersist;

@Log4j2
public class LogEntityListener {

    @PrePersist
    public void prePersist(Object obj) {
        log.debug(" {} : {} ", obj.getClass(), obj);
    }

}
