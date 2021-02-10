package org.buldakov.dailymassage.dao;

import org.buldakov.dailymassage.Models.Massage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MassageDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MassageDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Massage> getAll() {
        return jdbcTemplate.query("SELECT id_massage, massage.massage, count(\"Diary\".massage) as count FROM massage LEFT JOIN \"Diary\"\n" +
                "       ON massage.massage = \"Diary\".massage Group by massage.id_massage order by id_massage;", new MassageMapper());
    }

    public Massage getOne(int id) {
        return jdbcTemplate.query("SELECT * FROM massage WHERE id_massage=?", new Object[]{id}, new MassageMapper())
                .stream().findAny().orElse(null);
    }
}
