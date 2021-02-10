package org.buldakov.dailymassage.dao;

import org.buldakov.dailymassage.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM User", new UserMapper());
    }

    public User getOne(String login) {
        return jdbcTemplate.query("SELECT * FROM \"user\" WHERE login=?", new Object[]{login}, new UserMapper())
                .stream().findAny().orElse(null);
    }

}