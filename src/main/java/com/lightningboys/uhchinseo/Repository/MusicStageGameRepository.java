package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.MusicStageGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicStageGameRepository extends JpaRepository <MusicStageGame, Long> {

    Page<MusicStageGame> findAll(Pageable pageable);

}
