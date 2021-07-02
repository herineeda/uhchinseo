package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.MusicStageGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MusicStageGameRepository extends JpaRepository <MusicStageGame, Long> {

    Page<MusicStageGame> findAll(Pageable pageable);

    @Modifying
    @Query("update Music_Stage_Game ms set ms.score =: musicStageScore where ms.musicStageImage.id =:id")
    void updateScore(@Param("id")Long id, @Param("musicStageScore")int musicStageScore);

}
