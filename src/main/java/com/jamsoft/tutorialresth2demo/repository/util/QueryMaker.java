package com.jamsoft.tutorialresth2demo.repository.util;

import com.jamsoft.tutorialresth2demo.model.Tutorial;

public class QueryMaker {

    public static String save(Tutorial tutorial){
        final String q = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES(?,?,?,?,?,?)",
                Tutorial.TableInfo.TABLE_NAME,
                Tutorial.TableInfo.Title,
                Tutorial.TableInfo.Description,
                Tutorial.TableInfo.Published,
                Tutorial.TableInfo.CategoryId,
                Tutorial.TableInfo.CreatedTime,
                Tutorial.TableInfo.UpdateTime);
        return q;
    }

    public static String update(Tutorial tutorial){
        final String q = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
                Tutorial.TableInfo.TABLE_NAME,
                Tutorial.TableInfo.Title,
                Tutorial.TableInfo.Description,
                Tutorial.TableInfo.Published,
                Tutorial.TableInfo.CategoryId,
                Tutorial.TableInfo.CreatedTime,
                Tutorial.TableInfo.UpdateTime,
                Tutorial.TableInfo.Id);
        return q;
    }

    public static String delete(Tutorial tutorial){
        final String q = String.format("DELETE FROM %s WHERE %s=?)",
                Tutorial.TableInfo.TABLE_NAME, Tutorial.TableInfo.Id);
        return q;
    }

    public static String deleteAllTutorial(){
        final String q = String.format("DELETE FROM %s", Tutorial.TableInfo.TABLE_NAME);
        return q;
    }

    public static String getAllTutorial(){
        final String q = String.format("SELECT * FROM %s", Tutorial.TableInfo.TABLE_NAME);
        return q;
    }

    public static String getById(Tutorial tutorial){
        final String q = String.format("SELECT * FROM %s WHERE %s=%d", Tutorial.TableInfo.TABLE_NAME, Tutorial.TableInfo.Id, tutorial.getId());
        return q;
    }





}
