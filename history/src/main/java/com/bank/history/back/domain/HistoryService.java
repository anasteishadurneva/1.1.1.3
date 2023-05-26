package com.bank.history.back.domain;


import com.bank.history.back.dto.HistoryDto;
import com.bank.history.back.dto.HistoryProjectionDto;
import com.bank.history.back.dto.HistorySummaryProjectionDto;

import java.util.List;

public interface HistoryService {

    History create(HistoryDto dto);

    List<HistoryProjectionDto> findLatest();

    List<HistorySummaryProjectionDto> findSummary();


}
