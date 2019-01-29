package com.game.screeningoutput.service.impl;

import com.game.screeningoutput.entity.Option;
import com.game.screeningoutput.repository.OptionRepository;
import com.game.screeningoutput.service.OptionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class OptionServiceImpl implements OptionServiceInterface {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public void add(Option option) {
        optionRepository.save(option);
    }

    @Override
    public List<Option> getByQuestionId(String questionId) {
        return optionRepository.findByQuestionId(questionId);
    }
}
