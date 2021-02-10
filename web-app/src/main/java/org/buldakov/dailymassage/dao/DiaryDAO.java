package org.buldakov.dailymassage.dao;

import org.buldakov.dailymassage.Models.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Component
public class DiaryDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DiaryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Diary> getAll() {
        return jdbcTemplate.query("SELECT * FROM \"Diary\"", new DiaryMapper());
    }

    public Diary getOne(Date date) {
        return jdbcTemplate.query("SELECT * FROM \"Diary\" WHERE date_of_mas=?", new Object[]{date}, new DiaryMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Diary diary) {
        jdbcTemplate.update("INSERT INTO \"Diary\"(Date_of_mas, massage) VALUES(?, ?)", diary.getDate(), diary.getMassage());
    }

    public void update(Timestamp Date_of_mas, Diary updatedDiary) {
        jdbcTemplate.update("UPDATE User SET Date_of_mas=?, massage=? WHERE Date_of_mas=?", updatedDiary.getDate(),
                updatedDiary.getMassage(), Date_of_mas);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM User WHERE id=?", id);
    }

}

