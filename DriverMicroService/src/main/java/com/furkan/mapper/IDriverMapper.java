package com.furkan.mapper;

import com.furkan.rabbitmq.consumer.ConsumerDriverSave;
import com.furkan.rabbitmq.messagemodel.MessageModelSaveDriver;
import com.furkan.repository.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDriverMapper {
    IDriverMapper INSTANCE= Mappers.getMapper(IDriverMapper.class);
    Driver toDriver(final MessageModelSaveDriver model);
}
