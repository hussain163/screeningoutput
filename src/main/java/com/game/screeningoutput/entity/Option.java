package com.game.screeningoutput.entity;




import javax.persistence.*;


@Entity
@Embeddable
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String optionId;
    private String questionId;
    private String optionContent;


    public Option(String questionId, String optionContent) {
        this.questionId = questionId;
        this.optionContent = optionContent;
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
