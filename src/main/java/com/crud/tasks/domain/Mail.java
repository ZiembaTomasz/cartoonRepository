package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@lombok.Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

}
