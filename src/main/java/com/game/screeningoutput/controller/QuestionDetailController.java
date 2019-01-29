package com.game.screeningoutput.controller;


import com.game.screeningoutput.dto.QuestionDetailDTO;
import com.game.screeningoutput.entity.Option;
import com.game.screeningoutput.entity.QuestionDetail;
import com.game.screeningoutput.service.QuestionDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionDetailController {

@Autowired
    QuestionDetailService questionDetailService;


@PostMapping(value = "/addQuestion")
    void add(@RequestBody QuestionDetailDTO questionDetailDTO){
    QuestionDetail questionDetail=new QuestionDetail();
    BeanUtils.copyProperties(questionDetailDTO,questionDetail);
    String options = questionDetailDTO.getOptionList();
    String correctOptions = questionDetailDTO.getCorrectOptionList();
    String optionList[] = options.split(",");
    ArrayList<Option> optionObjectList = new ArrayList<>();

    for (String op: optionList) {
        optionObjectList.add(new Option(questionDetailDTO.getQuestionId(), op));
    }

    ArrayList<Option> correctAnswerObjectList = new ArrayList<>();
    String correctAnswers[] = questionDetailDTO.getCorrectOptionList().split(",");
    for (String correctAns: correctAnswers) {
        for(Option op: optionObjectList){
            if(op.getOptionContent().equals(correctAns)){
                correctAnswerObjectList.add(new Option(op.getOptionId(), correctAns));
            }

        }
    }
    questionDetail.setCorrectList(correctAnswerObjectList);
    questionDetail.setOptionList(optionObjectList);
    questionDetailService.add(questionDetail);

}






}
