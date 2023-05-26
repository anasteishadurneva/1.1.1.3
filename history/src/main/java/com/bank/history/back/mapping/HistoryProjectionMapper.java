package com.bank.history.back.mapping;


import com.bank.history.back.domain.History;
import com.bank.history.back.dto.HistoryProjectionDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryProjectionMapper {

    HistoryProjectionDto toDto(History entity);
    List<HistoryProjectionDto> toDtoList(List<History> entities);
}
