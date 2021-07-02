package com.lightningboys.uhchinseo.Service;


import com.lightningboys.uhchinseo.Domain.MusicStageGame;
import com.lightningboys.uhchinseo.Repository.MusicStageGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MusicGameService {

    private final MusicStageGameRepository musicStageGameRepository;

    public Page<MusicStageGame> findAll(int pageNum){
        return musicStageGameRepository.findAll(PageRequest.of(pageNum-1, 3));
    }

}
