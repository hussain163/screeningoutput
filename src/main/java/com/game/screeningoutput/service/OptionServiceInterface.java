package com.game.screeningoutput.service;

import com.game.screeningoutput.entity.Option;

import java.util.List;

public interface OptionServiceInterface {

    void add(Option option);
    List<Option> getByQuestionId(String questionId);

}
