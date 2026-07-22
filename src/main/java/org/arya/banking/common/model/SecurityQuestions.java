package org.arya.banking.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Builder
@Schema(description = "Security question and answer pair")
public class SecurityQuestions {

    @Field("question")
    @Schema(description = "Security question", example = "What is your mother's maiden name?")
    private String question;

    @Field("answer")
    @Schema(description = "Answer to the security question", example = "Smith")
    private String answer;
}
