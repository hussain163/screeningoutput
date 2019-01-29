package com.game.screeningoutput.dto;



public class OptionDTO {

    private String questionId;
    private String optionId;
    private String optionContent;
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
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
        return "OptionDTO{" +
                "optionId='" + optionId + '\'' +
                ", optionContent='" + optionContent + '\'' +
                '}';
    }
}


