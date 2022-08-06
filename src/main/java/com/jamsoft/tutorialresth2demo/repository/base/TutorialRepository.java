package com.jamsoft.tutorialresth2demo.repository.base;

import com.jamsoft.tutorialresth2demo.model.Category;
import com.jamsoft.tutorialresth2demo.model.Tutorial;

import java.util.List;

public interface TutorialRepository {

    int save(Tutorial tutorial);

    int update(Tutorial tutorial);

    int delete(int id);

    int deleteAll();

    List<Tutorial> getAll();

    Tutorial getById(int id);

    List<Tutorial> findByTitleKeyWord(String keyWord);

    List<Tutorial> findPublished(boolean isPublished);

    List<Tutorial> findByCategory(int categoryId);


}
