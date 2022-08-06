package com.jamsoft.tutorialresth2demo.repository;

import com.jamsoft.tutorialresth2demo.model.Tutorial;
import com.jamsoft.tutorialresth2demo.repository.base.TutorialRepository;
import com.jamsoft.tutorialresth2demo.repository.util.QueryMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTutorialRepository implements TutorialRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Tutorial tutorial) {
        final String q = QueryMaker.save(tutorial);
        Object[] objects = {tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getCategoryId(), tutorial.getCreatedTime(), tutorial.getUpdatedTime()};
        return jdbcTemplate.update(q, objects);
    }

    @Override
    public int update(Tutorial tutorial) {

        final String q = QueryMaker.update(tutorial);
        Object[] objects = {
                tutorial.getTitle(), tutorial.getDescription(),
                tutorial.isPublished(), tutorial.getCategoryId(), tutorial.getCreatedTime(), tutorial.getUpdatedTime()};
        return jdbcTemplate.update(q, objects, tutorial.getId());
    }

    @Override
    public int delete(int id) {
        Tutorial tutorial = new Tutorial();
        tutorial.setId(id);
        String q = QueryMaker.delete(tutorial);
        return jdbcTemplate.update(q, id);
    }

    @Override
    public int deleteAll() {
        final String  q = QueryMaker.deleteAllTutorial();
        return jdbcTemplate.update(q);
    }

    @Override
    public List<Tutorial> getAll() {
        final String q = QueryMaker.getAllTutorial();
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public Tutorial getById(int id) {
        final String  q = QueryMaker.getById(Tutorial.getById(id));
        return jdbcTemplate.queryForObject(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findByTitleKeyWord(String keyWord) {
        final String  q = String.format("SELECT * FROM %s WHERE %s LIKE '%%s%'", Tutorial.TableInfo.TABLE_NAME, Tutorial.TableInfo.Title, keyWord);
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findPublished(boolean isPublished) {
        final String q= String.format("SELECT * FROM %s WHERE %s=%s", Tutorial.TableInfo.TABLE_NAME, Tutorial.TableInfo.Published, isPublished);
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findByCategory(int categoryId) {
        final String q = String.format("SELECT * FROM %s WHERE %s=%s", Tutorial.TableInfo.TABLE_NAME, Tutorial.TableInfo.CategoryId, categoryId);
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }
}
