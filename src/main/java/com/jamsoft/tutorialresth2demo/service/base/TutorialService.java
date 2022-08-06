package com.jamsoft.tutorialresth2demo.service.base;

import com.jamsoft.tutorialresth2demo.model.Category;
import com.jamsoft.tutorialresth2demo.model.Tutorial;

import java.util.List;

public interface TutorialService {

    int save(Tutorial tutorial);

    int update(Tutorial tutorial);

    int deleteById(int id);

    int deleteAll();

    List<Tutorial> getAll();

    List<Tutorial> findByKeyWord(String keyWord);

    Tutorial getById(int id);

    List<Tutorial> findByCategory(int categoryId);

    List<Tutorial> findByPublished(boolean isPublished);
}
