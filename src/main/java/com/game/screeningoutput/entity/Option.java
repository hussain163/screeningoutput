package com.game.screeningoutput.entity;




import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Embeddable
public class Option {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String optionId;
    private String questionId;
    private String optionContent;
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Option(){}

    public Option(String questionId, String optionContent, boolean isCorrect) {
        this.questionId = questionId;
        this.optionContent = optionContent;
        this.isCorrect = isCorrect;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Option{");
        sb.append("questionId='").append(questionId).append('\'');
        sb.append(", optionId='").append(optionId).append('\'');
        sb.append(", optionContent='").append(optionContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
