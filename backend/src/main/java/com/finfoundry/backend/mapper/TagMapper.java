package com.finfoundry.backend.mapper;

import com.finfoundry.backend.dto.inputDTO.CreateTagRequest;
import com.finfoundry.backend.dto.outputDTO.TagDTO;
import com.finfoundry.backend.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDTO toTagDTO(Tag tag);
    Tag fromCreateTagRequest(CreateTagRequest request);
}