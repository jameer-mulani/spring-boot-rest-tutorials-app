package com.jamsoft.tutorialresth2demo.repository;

import com.jamsoft.tutorialresth2demo.model.Category;
import com.jamsoft.tutorialresth2demo.repository.base.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class JdbcCategoryRepository implements CategoryRepository {

    private static final String CategoryTableName = "tutorial_categories";


    /*
     *Auto-wiring JdbcTemplate instance, using below methods
     * update -> uses query and objects params to execute queries
     * queryForObject -> query specific object with sql query, row mapper and condition objects
     * query -> query all objects takes sql and row mapper
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(Category category) {
        String query = String.format("INSERT INTO %s (name, description) VALUES (?,?)", CategoryTableName);
        Object[] objects = new Object[]{category.getName(), category.getDescription()};
        return jdbcTemplate.update(query, objects);
    }

    @Override
    public int update(Category category) {

        String query = String.format("UPDATE %s SET name=?, description=? WHERE id=?", CategoryTableName);
        Object[] objects = {category.getName(), category.getDescription(), category.getId()};
        return jdbcTemplate.update(query, objects);
    }

    @Override
    public int delete(Category category) {
        final int id = category.getId();
        return deleteById(id);
    }

    @Override
    public List<Integer> deleteAll() {
        final String q = String.format("DELETE FROM %s", CategoryTableName);
        int result = jdbcTemplate.update(q);
        return Arrays.asList(result);
    }

    @Override
    public int deleteById(int categoryId) {

        final String query = String.format(
                "DELETE FROM %s WHERE id=?", CategoryTableName);
        return jdbcTemplate.update(query, categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        String q = String.format("SELECT * FROM %s", CategoryTableName);
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Category.class));
    }

    @Override
    public Category getById(int id) {
        final String query = String.format("SELECT * FROM %s WHERE id=?", CategoryTableName);
        return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Category.class), id);
    }

    @Override
    public List<Category> getByName(String name) {
        final String query = String.format(
                "SELECT * FROM %s WHERE title LIKE '%%s%'", CategoryTableName, name);
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Category.class));
    }
}
