package com.sparta.miniproject.entity;

import com.sparta.miniproject.dto.MemoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "memo")
@NoArgsConstructor
public class Memo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eventname", nullable = false)
    private String eventname;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private String time;

    public Memo (MemoRequestDto requestDto) {
        this.eventname = requestDto.getEventname();
        this.date = requestDto.getDate();
        this.time = requestDto.getTime();
    }

    public void update(MemoRequestDto requestDto) {
        this.eventname = requestDto.getEventname();
        this.date = requestDto.getDate();
        this.time = requestDto.getTime();
    }
}
