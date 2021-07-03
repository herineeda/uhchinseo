package com.lightningboys.uhchinseo.Repository;


import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.BalanceGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BalanceGameRepository extends JpaRepository<BalanceGame, Long> {

    @Query("select b from Balance_Game b where b.category =:id ")
   List<BalanceGame> findRandomQ(@RequestParam("id")int id, Pageable pageable);
}
