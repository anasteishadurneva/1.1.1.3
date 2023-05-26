package com.bank.history.back.domain;

import com.bank.history.back.dto.HistorySummaryProjectionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<HistorySummaryProjectionDto> findAllByUsername(String username);


}
