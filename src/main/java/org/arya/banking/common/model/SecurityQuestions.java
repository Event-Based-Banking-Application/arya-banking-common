package org.arya.banking.common.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class SecurityQuestions {

    @Field("question")
    private String question;

    @Field("answer")
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
