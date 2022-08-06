package com.jamsoft.tutorialresth2demo.controller;

import com.jamsoft.tutorialresth2demo.model.Category;
import com.jamsoft.tutorialresth2demo.service.base.TutorialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(Constants.TutorialControllerBaseMapping)
public class TutorialCategoryController {

    private final static String PATH = "category";

    @Autowired
    TutorialCategoryService service;

    @GetMapping(PATH)
    public ResponseEntity<List<Category>> getAllCategories(){
        try {
           List<Category> categories = service.getAllCategories();
           if (categories != null && !categories.isEmpty()){
               return new ResponseEntity<>(categories, HttpStatus.OK);
           }
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }catch (Exception e){
            e.printStackTrace();
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PostMapping(PATH)
    public ResponseEntity<Integer> createNewCategory(@RequestBody Category category){
        try {
            int result = service.saveCategory(category);
            if (result > -1){
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(PATH+"/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
       try {

           Category _category = service.getById(id);
           _category.setName(category.getName());
           _category.setDescription(category.getDescription());

           int result = service.updateCategory(_category);

           category.setId(_category.getId());

           if (result > -1){
               return new ResponseEntity<>(category, HttpStatus.OK);
           }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping(PATH)
    public ResponseEntity<Integer> deleteAll(){
        try {
            int result = service.deleteAllCategories();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(PATH+"/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable int id){
        try {
            int result = service.deleteById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
