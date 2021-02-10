package org.buldakov.dailymassage.dao;

import org.buldakov.dailymassage.Models.Massage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MassageMapper implements RowMapper<Massage> {
    @Override
    public Massage mapRow(ResultSet resultSet, int i) throws SQLException {
        Massage massage = new Massage();

        massage.setId(resultSet.getInt("id_massage"));
        massage.setMessage(resultSet.getString("massage"));
        massage.setCount(resultSet.getInt("count"));

        return massage;
    }
}
