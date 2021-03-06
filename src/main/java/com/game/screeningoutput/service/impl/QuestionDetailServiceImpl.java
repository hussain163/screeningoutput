package com.game.screeningoutput.service.impl;

import com.game.screeningoutput.entity.QuestionDetail;
import com.game.screeningoutput.repository.QuestionDetailRepository;
import com.game.screeningoutput.service.QuestionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
public class QuestionDetailServiceImpl implements QuestionDetailService {

    @Autowired
    QuestionDetailRepository questionDetailRepository;

    @Override
    @Transactional(readOnly = false)
    public void add(QuestionDetail questionDetail) {
        questionDetailRepository.save(questionDetail);
    }

    @Override
    public List<QuestionDetail> selectAll() {
        return (List<QuestionDetail>) questionDetailRepository.findAll();
    }

    @Override
    public QuestionDetail select(String questionId) {
        return questionDetailRepository.findOne(questionId);
    }

    @Override
    public List<QuestionDetail> findByQuestionCategory(String categoryName) {
        return questionDetailRepository.findByQuestionCategory(categoryName);
    }

    @Override
    public List<QuestionDetail> findByQuestionType(String mediaType) {
        return questionDetailRepository.findByQuestionType(mediaType);
    }

    @Override
    public List<QuestionDetail> findByQuestionTypeAndQuestionCategory(String questionType, String questionCategory) {
        return questionDetailRepository.findQuestionDetailByQuestionCategoryAndQuestionType(questionCategory, questionType);
    }
}
