package com.bank.history.back.mapping;


import com.bank.history.back.domain.History;
import com.bank.history.back.dto.HistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoryMapper {
    @Mapping(target = "id", ignore = true)
    History toEntity(HistoryDto dto);

    HistoryDto toDto(History entity);

}