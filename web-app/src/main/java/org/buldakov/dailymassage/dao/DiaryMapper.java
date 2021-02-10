package org.buldakov.dailymassage.dao;

import org.buldakov.dailymassage.Models.Diary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiaryMapper implements RowMapper<Diary> {
    @Override
    public Diary mapRow(ResultSet resultSet, int i) throws SQLException {
        Diary diary= new Diary();

        diary.setMassage(resultSet.getString("massage"));
        diary.setId(resultSet.getInt("diary_id"));
        diary.setDate(resultSet.getDate("date_of_mas"));

        return diary;
    }
}
