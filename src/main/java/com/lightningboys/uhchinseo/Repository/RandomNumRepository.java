package com.lightningboys.uhchinseo.Repository;

import com.lightningboys.uhchinseo.Domain.RandomNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface RandomNumRepository extends JpaRepository<RandomNum, Long> {
    Optional<RandomNum> findById (int id);

    @Modifying
    @Transactional
    @Query(value = "insert into random_num(id) values (:id)",
    nativeQuery = true)
    void insertId(@RequestParam("id")int id);

    @Modifying
    @Transactional
    @Query(value = "truncate table random_num", nativeQuery = true)
    void truncateTable();
}
