package org.buldakov.dailymassage.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.buldakov.dailymassage.dao.DiaryDAO;
import org.buldakov.dailymassage.dao.MassageDAO;
import org.buldakov.dailymassage.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DailyMassage {

    private final UserDAO userDAO;
    private final DiaryDAO diaryDAO;
    private final MassageDAO messageDAO;

    @Autowired
    public DailyMassage( UserDAO userDAO, DiaryDAO diaryDAO, MassageDAO messageDAO) {
        this.userDAO = userDAO;
        this.diaryDAO = diaryDAO;
        this.messageDAO = messageDAO;
    }

    @CrossOrigin
    @GetMapping("/dailyMassage")
    public String sendMessages() {
        ObjectMapper objectMapper = new ObjectMapper();
        diaryDAO.getAll();
        try {
            String request = objectMapper.writeValueAsString(diaryDAO);
            return request;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
