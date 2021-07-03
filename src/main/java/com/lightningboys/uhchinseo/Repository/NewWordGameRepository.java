package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.NewWordGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface NewWordGameRepository extends JpaRepository<NewWordGame, Long> {

    @Query("select n from new_word_game n where n.category =:id")
   List<NewWordGame> randomQuiz (@RequestParam("id")int id, Pageable pageable);
}
