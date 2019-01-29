package com.game.screeningoutput.repository;

import com.game.screeningoutput.entity.QuestionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionDetailRepository extends CrudRepository<QuestionDetail,String> {


}
