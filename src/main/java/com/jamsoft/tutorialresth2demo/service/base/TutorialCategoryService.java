package com.jamsoft.tutorialresth2demo.service.base;

import com.jamsoft.tutorialresth2demo.model.Category;

import java.util.List;

public interface TutorialCategoryService {

    int saveCategory(Category category);

    List<Category> getAllCategories();

    Category getById(int id);

    int updateCategory(Category category);

    int deleteCategory(Category category);

    int deleteById(int id);

    int deleteAllCategories();


}
