package com.lightningboys.uhchinseo.Service;
import com.lightningboys.uhchinseo.Domain.NewWordGame;
import com.lightningboys.uhchinseo.Repository.NewWordGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NewWordGameService {

    private final NewWordGameRepository newWordGameRepository;
    public Page<NewWordGame> findAll(int pageNum) {
        return newWordGameRepository.findAll(PageRequest.of(-1, 3));
    }
    @Transactional
    public void updateScore(Long id, int newWordScore) {
        newWordGameRepository.updateScore(id, newWordScore + 10);
    }
}
