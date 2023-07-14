package com.sparta.miniproject.dto;

import com.sparta.miniproject.entity.Memo;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {

    private Long id;
    private String eventname;
    private String time;
    private LocalDate date;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public MemoResponseDto(Memo memo){
        this.id = memo.getId();
        this.eventname = memo.getEventname();
        this.date = memo.getDate();
        this.time = memo.getTime();
        this.createdAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();

    }
}
