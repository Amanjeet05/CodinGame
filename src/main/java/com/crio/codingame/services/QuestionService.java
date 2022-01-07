package com.crio.codingame.services;

import java.util.Collections;
import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.repositories.IQuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    String id = "1";

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Create and store Question into the repository.

    @Override
    public Question create(String title, Level level, Integer difficultyScore) {

        Question newQuestion = new Question(id,title, level, difficultyScore);
        int z  = Integer.parseInt(id);
        z++;
        id = String.valueOf(z);
        questionRepository.save(newQuestion);
        return newQuestion;  
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {

        if(level == null)
            return questionRepository.findAll();
        
        return questionRepository.findAllQuestionLevelWise(level);
    }
    
}