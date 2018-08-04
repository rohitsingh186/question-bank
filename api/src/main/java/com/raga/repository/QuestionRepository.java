package com.raga.repository;

import com.raga.vo.Option;
import com.raga.vo.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String> {
}
