package com.jamsoft.tutorialresth2demo.service;

import com.jamsoft.tutorialresth2demo.model.Tutorial;
import com.jamsoft.tutorialresth2demo.repository.base.TutorialRepository;
import com.jamsoft.tutorialresth2demo.service.base.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    TutorialRepository tutorialRepository;

    @Override
    public int save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public int update(Tutorial tutorial) {
        return tutorialRepository.update(tutorial);
    }

    @Override
    public int deleteById(int id) {
        return tutorialRepository.delete(id);
    }

    @Override
    public int deleteAll() {
        return tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> getAll() {
        return tutorialRepository.getAll();
    }

    @Override
    public List<Tutorial> findByKeyWord(String keyWord) {
        return tutorialRepository.findByTitleKeyWord(keyWord);
    }

    @Override
    public Tutorial getById(int id) {
        return tutorialRepository.getById(id);
    }

    @Override
    public List<Tutorial> findByCategory(int categoryId) {
        return tutorialRepository.findByCategory(categoryId);
    }

    @Override
    public List<Tutorial> findByPublished(boolean isPublished) {
        return tutorialRepository.findPublished(isPublished);
    }
}
