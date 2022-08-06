package com.jamsoft.tutorialresth2demo.model;

import java.util.Date;

public class Tutorial {

    public interface TableInfo{
        String TABLE_NAME = "tutorials";
        String Id = "id";
        String Title = "title";
        String Description = "description";
        String Published = "published";
        String CategoryId  = "category_id";
        String CreatedTime = "created_time";
        String UpdateTime  = "updated_time";
    }

    private long id;
    private String title;
    private String description;
    private boolean published;
    private int categoryId;
    private long createdTime;
    private long updatedTime;

    public Tutorial() {
    }

    public static Tutorial getById(long id){
        Tutorial tutorial = new Tutorial();
        tutorial.setId(id);
        return tutorial;
    }

    public Tutorial(String title, String description, boolean published, int categoryId, long createdTime, long updatedTime) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.categoryId = categoryId;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Tutorial(long id, String title, String description, boolean published, int categoryId, long createdTime, long updatedTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
        this.categoryId = categoryId;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }
}
