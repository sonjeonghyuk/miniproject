package com.sparta.miniproject.repository;

import com.sparta.miniproject.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAll();
}
