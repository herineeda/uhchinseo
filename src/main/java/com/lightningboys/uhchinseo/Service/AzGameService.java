package com.lightningboys.uhchinseo.Service;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Repository.AzGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AzGameService {

    private final AzGameRepository azGameRepository;
    public List<AZGame> findRandomQ(Integer randomNumber, int pageNum){

        return azGameRepository.findRandomQuiz(randomNumber, PageRequest.of(pageNum-1, 3));
    }
}
