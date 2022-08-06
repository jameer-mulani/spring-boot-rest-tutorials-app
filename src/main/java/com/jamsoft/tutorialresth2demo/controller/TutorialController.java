package com.jamsoft.tutorialresth2demo.controller;

import com.jamsoft.tutorialresth2demo.model.Tutorial;
import com.jamsoft.tutorialresth2demo.service.base.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.TutorialControllerBaseMapping)
public class TutorialController {

    final static String PATH = "tutorial";

    @Autowired
    TutorialService tutorialService;

    @GetMapping(PATH)
    public ResponseEntity<List<Tutorial>> getAll(){

        try {
            List<Tutorial> result = tutorialService.getAll();
            if (result != null && !result.isEmpty()){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping(PATH)
    public ResponseEntity<List<Tutorial>> getAllByKeyWord(@RequestParam(required = false, defaultValue = "title", value = "title") String keyword){

        try {
            List<Tutorial> result = tutorialService.findByKeyWord(keyword);
            if (result != null && !result.isEmpty()){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(PATH)
    public ResponseEntity<List<Tutorial>> getAllByCategory(@RequestParam(required = false, defaultValue = "category", value = "category") int id){

        try {
            List<Tutorial> result = tutorialService.findByCategory(id);
            if (result != null && !result.isEmpty()){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(PATH)
    public ResponseEntity<List<Tutorial>> getAllByPublished(@RequestParam(required = false, defaultValue = "published", value = "published") boolean pb){

        try {
            List<Tutorial> result = tutorialService.findByPublished(pb);
            if (result != null && !result.isEmpty()){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PostMapping(PATH)
    public ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial){
        try {
             int result = tutorialService.save(tutorial);
             if (result >-1){
                 tutorial.setId(result);
                 return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
             }
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(PATH+"/{id}")
    public ResponseEntity<Integer> update(@PathVariable int id, @RequestBody Tutorial tutorial){
        try {
            int result = tutorialService.update(tutorial);
            if (result > -1){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(PATH+"/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id){
        try {
            int result = tutorialService.deleteById(id);
            if (result > -1){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(PATH)
    public ResponseEntity<Integer> delete(){
        try {
            int result = tutorialService.deleteAll();
            if (result > -1){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
