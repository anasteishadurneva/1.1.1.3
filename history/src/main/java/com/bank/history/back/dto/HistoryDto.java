package com.bank.history.back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {

    private Long id;

    private String username;

    private String action;

    private String details;

    private Long timestamp;
}
