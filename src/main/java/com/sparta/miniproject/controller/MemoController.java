package com.sparta.miniproject.controller;

import com.sparta.miniproject.dto.DeleteResponseDto;
import com.sparta.miniproject.dto.MemoRequestDto;
import com.sparta.miniproject.dto.MemoResponseDto;
import com.sparta.miniproject.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memo")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memo/{date}")
    public List<MemoResponseDto> getMemo(@PathVariable LocalDate date) {
        return memoService.getMemo(date);
    }

    @GetMapping("/memo")
    public List<MemoResponseDto> getMemos(){
        return memoService.getMemos();
    }


    @PutMapping("/memo/{id}")
    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memo/{id}")
    public DeleteResponseDto deleteMemo(@PathVariable Long id){
        return memoService.deleteMemo(id);
    }

}
