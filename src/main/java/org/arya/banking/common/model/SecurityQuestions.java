package org.arya.banking.common.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Builder
public class SecurityQuestions {

    @Field("question")
    private String question;

    @Field("answer")
    private String answer;
}
