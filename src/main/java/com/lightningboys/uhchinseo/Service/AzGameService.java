package com.lightningboys.uhchinseo.Service;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.RandomNum;
import com.lightningboys.uhchinseo.Repository.AzGameRepository;
import com.lightningboys.uhchinseo.Repository.RandomNumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AzGameService {

    private final AzGameRepository azGameRepository;
    private final RandomNumRepository randomNumRepository;
    public List<AZGame> findRandomQ(Integer randomNumber){

        return azGameRepository.findRandomQuiz(randomNumber);
    }
    /*List<Integer> randomNumber = new ArrayList<>();
        for(int i=0; i<10; i++){
            randomNumber.add((rd.nextInt(31)+1));
            for(int j=0; j<i;j++) {
                if(randomNumber.get(i) == randomNumber.get(j)) {i--; break;}
            }
        }*/

    @Transactional
    public void truncate(){
        randomNumRepository.truncateTable();
    }
    @Transactional
    public Optional<RandomNum>  find(){
        Optional<RandomNum> r = randomNumRepository.findById(1);
        return r;
    }
    @Transactional
    public Integer randomNumber(){
        Random rd = new Random();
        int tmp = rd.nextInt(31)+1;
        try{
            Optional<RandomNum> r = randomNumRepository.findById(tmp);
            r.get();
        }
        catch (NoSuchElementException e){
            randomNumRepository.insertId(tmp);
            return tmp;
        }
        return -1;
    }
}
