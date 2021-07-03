package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.AZGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AzGameRepository extends JpaRepository<AZGame, Long> {

    Page<AZGame> findAll(Pageable pageable);

    @Query("select ag from az_game ag where ag.category in (:id)")
    List<AZGame> findRandomQuiz(@RequestParam("id")Integer id, Pageable pageable);
}
