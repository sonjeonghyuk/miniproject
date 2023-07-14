package com.sparta.miniproject.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemoRequestDto {
    private String eventname;
    private String time;
    private LocalDate date;
}
