package com.example.bootex.util;

import com.example.bootex.listener.LogEntityListener;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class, LogEntityListener.class})
@Getter
public abstract class DateEntity {

    @CreatedDate
    @Column(nullable = false, name = "regdate")
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(nullable = false, name = "moddate")
    private LocalDateTime modDate;
}
