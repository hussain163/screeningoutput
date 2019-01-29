package com.game.screeningoutput.controller;


import com.game.screeningoutput.dto.CheckAnswerDTO;
import com.game.screeningoutput.dto.OptionDTO;
import com.game.screeningoutput.dto.QuestionDetailDTO;
import com.game.screeningoutput.dto.QuestionDetailResponseDTO;
import com.game.screeningoutput.entity.Option;
import com.game.screeningoutput.entity.QuestionDetail;
import com.game.screeningoutput.service.OptionServiceInterface;
import com.game.screeningoutput.service.QuestionDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionDetailController {

    @Autowired
    QuestionDetailService questionDetailService;

    @Autowired
    OptionServiceInterface optionServiceInterface;

@PostMapping(value = "/addQuestion")
    void add(@RequestBody QuestionDetailDTO questionDetailDTO){
    QuestionDetail questionDetail=new QuestionDetail();
    BeanUtils.copyProperties(questionDetailDTO,questionDetail);
    String options = questionDetailDTO.getOptionList();
    String optionList[] = options.split(",");
    questionDetailService.add(questionDetail);

    String[] correctAns=questionDetailDTO.getCorrectAnswer().split(",");
    System.out.println(correctAns);
    for (String op: optionList) {
        int flag = 0;
        for (String ca : correctAns) {
            if (ca.equals(op)) {
                flag = 1;
                optionServiceInterface.add(new Option(questionDetail.getQuestionId(), op, true));
            }
        }
        if (flag == 0) {
            optionServiceInterface.add(new Option(questionDetail.getQuestionId(), op, false));
        }
    }

}


    @GetMapping(value = "/getAll")
    public List<QuestionDetailResponseDTO> getAll(){

        List<QuestionDetailResponseDTO> questionDetailResponseDTOS = new ArrayList<>();
        List<QuestionDetail> questionDetails = questionDetailService.selectAll();

        for(QuestionDetail questionDetail:questionDetails){
            List<OptionDTO> optionDTOList = new ArrayList<>();

            QuestionDetailResponseDTO questionDetailResponseDTO = new QuestionDetailResponseDTO();

            for(Option option:optionServiceInterface.getByQuestionId(questionDetail.getQuestionId())){
                OptionDTO optionDTO=new OptionDTO();

                BeanUtils.copyProperties(option,optionDTO);
                optionDTOList.add(optionDTO);
            }
            BeanUtils.copyProperties(questionDetail, questionDetailResponseDTO);
            questionDetailResponseDTO.setOptionDTOList(optionDTOList);
            questionDetailResponseDTOS.add(questionDetailResponseDTO);
        }
        return questionDetailResponseDTOS;

    }



    @GetMapping(value = "/getByQuestionId/{questionId}")
    public QuestionDetailResponseDTO getByQuestionId(@PathVariable("questionId") String questionId){
        QuestionDetail questionDetail = questionDetailService.select(questionId);
        QuestionDetailResponseDTO questionDetailResponseDTO = new QuestionDetailResponseDTO();
        BeanUtils.copyProperties(questionDetail, questionDetailResponseDTO);

        List<OptionDTO> optionDTOList = new ArrayList<>();

        for(Option option: optionServiceInterface.getByQuestionId(questionId)){
            OptionDTO optionDTO=new OptionDTO();
            BeanUtils.copyProperties(option,optionDTO);
            optionDTOList.add(optionDTO);
        }
        questionDetailResponseDTO.setOptionDTOList(optionDTOList);

        return questionDetailResponseDTO;

    }


    @GetMapping(value = "/getByCategory/{categoryName}")
    public List<QuestionDetailResponseDTO> getByCategory(@PathVariable("categoryName") String categoryName){
        List<QuestionDetailResponseDTO> questionDetailResponseDTOS = new ArrayList<>();

        List<QuestionDetail> questionDetails = questionDetailService.findByCategory(categoryName);

        for(QuestionDetail questionDetail:questionDetails){
            List<OptionDTO> optionDTOList = new ArrayList<>();

            QuestionDetailResponseDTO questionDetailResponseDTO = new QuestionDetailResponseDTO();

            for(Option option:optionServiceInterface.getByQuestionId(questionDetail.getQuestionId())){
                OptionDTO optionDTO=new OptionDTO();

                BeanUtils.copyProperties(option,optionDTO);
                optionDTOList.add(optionDTO);
            }
            BeanUtils.copyProperties(questionDetail, questionDetailResponseDTO);
            questionDetailResponseDTO.setOptionDTOList(optionDTOList);
            questionDetailResponseDTOS.add(questionDetailResponseDTO);
        }
        return questionDetailResponseDTOS;
    }


    @PostMapping(value = "/checkAnswer")
    public boolean checkAnswer(@RequestBody CheckAnswerDTO checkAnswerDTO) {

        String[] userAnswer = checkAnswerDTO.getUserAnswer().split(",");
        List<Option> optionList = optionServiceInterface.getByQuestionId(checkAnswerDTO.getQuestionId());
        int count = 0;
        for (Option op : optionList) {
            if (op.isCorrect())
                count++;

        }
        if (userAnswer.length != count) {
            return false;
        }
        for (Option op : optionList) {
             if (op.isCorrect()){
             for(String ua: userAnswer){
                 if(ua.equals(op.getOptionId())){
                     count--;
                     break;
                 }
             }

                if(count==0){
                     return true;
                }


             }

        }
        return false;
    }


}






