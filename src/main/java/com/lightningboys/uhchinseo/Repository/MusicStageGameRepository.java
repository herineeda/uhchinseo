package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.MusicStageGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MusicStageGameRepository extends JpaRepository <MusicStageGame, Long> {

    @Query("select m from Music_Stage_Game m where m.musicStageImage =:id")
    List<MusicStageGame> randomQ(@RequestParam("id")int id);

}
