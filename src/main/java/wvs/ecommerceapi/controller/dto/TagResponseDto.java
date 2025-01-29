package wvs.ecommerceapi.controller.dto;

import wvs.ecommerceapi.entity.TagEntity;

public record TagResponseDto(Long tagId,
                             String tagName) {
    public static TagResponseDto fromEntity(TagEntity entity) {
        return new TagResponseDto(
                entity.getTagId(),
                entity.getName()
        );
    }
}
