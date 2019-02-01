package com.game.screeningoutput.service;

import com.game.screeningoutput.entity.Option;
import com.game.screeningoutput.entity.QuestionDetail;
import com.game.screeningoutput.repository.QuestionDetailRepository;

import java.util.List;

public interface QuestionDetailService  {


    public void add(QuestionDetail questionDetail);
    List<QuestionDetail> selectAll();
    QuestionDetail select(String questionId);
    List<QuestionDetail> findByQuestionCategory(String questionCategory);
    List<QuestionDetail> findByQuestionType(String questionType);
    List<QuestionDetail> findByQuestionTypeAndQuestionCategory(String questionType, String questionCategory);


    void deleteFromMongoDB(String questionId);
    boolean checkAnswer(String[] userAnswer, List<Option> optionList);

}
