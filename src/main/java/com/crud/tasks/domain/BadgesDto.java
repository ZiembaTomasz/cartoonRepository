package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BadgesDto {
    @JsonProperty("vote")
    private int vote;
    @JsonProperty("attachmentsByType")
    private AttachmentsByTypeDto attachmentsByType;
}
