package com.bank.history.back.domain;


import com.bank.history.back.dto.HistoryDto;
import com.bank.history.back.dto.HistoryProjectionDto;
import com.bank.history.back.dto.HistorySummaryProjectionDto;
import com.bank.history.back.exception.HistoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryServiceImpl historyService) {
        this.historyService = (HistoryService) historyService;
    }

    @PostMapping("/")
    public ResponseEntity<History> createHistory(@RequestBody HistoryDto dto) {
        History history = historyService.create(dto);
        return new ResponseEntity<>(history, HttpStatus.CREATED);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<HistoryProjectionDto>> getLatestHistory() {
        List<HistoryProjectionDto> history = historyService.findLatest();
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<HistorySummaryProjectionDto>> getSummaryHistory() {
        List<HistorySummaryProjectionDto> historySummary = historyService.findSummary();
        return new ResponseEntity<>(historySummary, HttpStatus.OK);
    }

    @ExceptionHandler(HistoryException.class)
    public ResponseEntity<String> handleHistoryException(HistoryException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}