package com.jamsoft.tutorialresth2demo.repository.base;

import com.jamsoft.tutorialresth2demo.model.Category;

import java.util.List;

public interface CategoryRepository {

    int save(Category category);
    int update(Category category);
    int delete(Category category);
    List<Integer> deleteAll();
    int deleteById(int categoryId);
    List<Category> getAllCategories();
    Category getById(int id);
    List<Category> getByName(String name);

}
