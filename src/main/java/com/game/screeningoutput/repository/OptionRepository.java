package com.game.screeningoutput.repository;

import com.game.screeningoutput.entity.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends CrudRepository<Option, String> {

    List<Option> findByQuestionId(String questionId);

}
