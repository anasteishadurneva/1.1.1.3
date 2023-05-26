package com.bank.history.back.domain;

import com.bank.history.back.exception.HistoryBadRequestException;
import com.bank.history.back.exception.HistoryConflictException;
import com.bank.history.back.exception.HistoryNotFoundException;
import com.bank.history.back.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl {

    private final HistoryRepository historyRepository;
    private final UserFeignClient userFeignClient;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository, @Qualifier("com.bank.history.back.feign.UserFeignClient") UserFeignClient userFeignClient) {
        this.historyRepository = historyRepository;
        this.userFeignClient = userFeignClient;
    }

    public History getHistoryById(Long id) {
        return historyRepository.findById(id).orElseThrow(() -> new HistoryNotFoundException("History not found"));
    }


    public History createHistory(History history) {
        if (historyRepository.existsById(history.getId())) {
            throw new HistoryConflictException("History already exists");
        }
        if (userFeignClient.getUserById(history.getUserId()) == null) {
            throw new HistoryBadRequestException("Invalid user ID");
        }
        return historyRepository.save(history);
    }

    public History updateHistory(History history) {
        if (!historyRepository.existsById(history.getId())) {
            throw new HistoryNotFoundException("History not found");
        }
        if (userFeignClient.getUserById(history.getUserId()) == null) {
            throw new HistoryBadRequestException("Invalid user ID");
        }
        return historyRepository.save(history);
    }

    public void deleteHistory(Long id) {
        if (!historyRepository.existsById(id)) {
            throw new HistoryNotFoundException("History not found");
        }
        historyRepository.deleteById(id);
    }

}
