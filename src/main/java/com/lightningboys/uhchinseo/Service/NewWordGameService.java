package com.lightningboys.uhchinseo.Service;
import com.lightningboys.uhchinseo.Domain.NewWordGame;
import com.lightningboys.uhchinseo.Repository.NewWordGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NewWordGameService {

    private final NewWordGameRepository newWordGameRepository;

    public List<NewWordGame> newWordGames(int randomNUmber){
        return newWordGameRepository.randomQuiz(randomNUmber);
    }
}
