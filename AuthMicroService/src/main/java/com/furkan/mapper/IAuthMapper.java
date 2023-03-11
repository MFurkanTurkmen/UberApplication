package com.furkan.mapper;

import com.furkan.dto.request.AuthSaveDto;
import com.furkan.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE= Mappers.getMapper(IAuthMapper.class);
    Auth toAuth(final AuthSaveDto dto);
    AuthSaveDto toDto(final Auth auth);
}
