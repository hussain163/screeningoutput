package com.game.screeningoutput.entity;


import javax.persistence.*;


@Entity
@Table(name = QuestionDetail.TABLE_NAME)
public class QuestionDetail {

    public static final String TABLE_NAME = "QUESTION_DETAIL";

    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(questionName = "uuid", strategy = "uuid2")
    private String questionId;
    private String questionName;
    private String questionContent;
    // private String correctAnswer;
    private String questionCategory;
    private String questionType;
    private String answerType;
    private String questionDifficulty;
    private int duration;


    public String getQuestionId() {
        return questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }


    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(String questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}



