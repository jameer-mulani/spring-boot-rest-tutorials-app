package com.jamsoft.tutorialresth2demo.service;

import com.jamsoft.tutorialresth2demo.model.Category;
import com.jamsoft.tutorialresth2demo.repository.base.CategoryRepository;
import com.jamsoft.tutorialresth2demo.service.base.TutorialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialTutorialCategoryServiceImpl implements TutorialCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public int saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public int deleteCategory(Category category) {
        return categoryRepository.deleteById(category.getId());
    }

    @Override
    public int deleteById(int id) {
        return categoryRepository.deleteById(id);
    }

    @Override
    public int deleteAllCategories() {
        List<Integer> result = categoryRepository.deleteAll();
        if (result != null && !result.isEmpty()){
            return result.get(0);
        }
        return -1;
    }
}
