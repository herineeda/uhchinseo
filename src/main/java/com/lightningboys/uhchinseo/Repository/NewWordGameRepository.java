package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.NewWordGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewWordGameRepository extends JpaRepository<NewWordGame, Long> {

    Page<NewWordGame> findAll(Pageable pageable);

    @Modifying
    @Query("update new_word_game nw set nw.answer =: newWordScore where nw.id =: id")
        //신조어게임 점수 세는 쿼리문 넣기
    void updateScore(@Param("id") Long id, @Param("newWordScore") int newWordScore);

}
