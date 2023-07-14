package com.sparta.miniproject.service;

import com.sparta.miniproject.dto.DeleteResponseDto;
import com.sparta.miniproject.dto.MemoRequestDto;
import com.sparta.miniproject.dto.MemoResponseDto;
import com.sparta.miniproject.entity.Memo;
import com.sparta.miniproject.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {

        Memo memo = new Memo(requestDto);
        Memo savememo = memoRepository.save(memo);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAll().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public MemoResponseDto updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = findMemo(id);
        memo.update(requestDto);
        return new MemoResponseDto(memo);
    }


    public DeleteResponseDto deleteMemo(Long id) {
        Memo memo = findMemo(id);
        memoRepository.delete(memo);
        return new DeleteResponseDto();
    }


    private Memo findMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다")
        );
    }

}
