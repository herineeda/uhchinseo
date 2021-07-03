package com.lightningboys.uhchinseo.Service;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.BalanceGame;
import com.lightningboys.uhchinseo.Repository.AzGameRepository;
import com.lightningboys.uhchinseo.Repository.BalanceGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BalanceGameService {

    private final BalanceGameRepository balanceGameRepository;

    public List<BalanceGame> balanceGameList(int randomNumber){
        return balanceGameRepository.findRandomQ(randomNumber);
    }
}
