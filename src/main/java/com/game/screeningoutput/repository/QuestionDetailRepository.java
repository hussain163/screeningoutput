package com.game.screeningoutput.repository;

import com.game.screeningoutput.entity.QuestionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDetailRepository extends CrudRepository<QuestionDetail,String> {


    List<QuestionDetail> findByCategory(String categoryName);

}
