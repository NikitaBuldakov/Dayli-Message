package org.buldakov.dailymassage.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.buldakov.dailymassage.Models.Diary;
import org.buldakov.dailymassage.dao.DiaryDAO;
import org.buldakov.dailymassage.dao.MassageDAO;
import org.buldakov.dailymassage.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class AdminPanel {

    private final MassageDAO massageDAO;
    private final UserDAO userDAO;
    private final DiaryDAO diaryDAO;

    @Autowired
    public AdminPanel(MassageDAO massageDAO, UserDAO userDAO, DiaryDAO diaryDAO) {
        this.massageDAO = massageDAO;
        this.userDAO = userDAO;
        this.diaryDAO = diaryDAO;
    }

    @CrossOrigin
    @GetMapping("/adminPanel")
    public String sendMessages() {
        ObjectMapper objectMapper = new ObjectMapper();
        massageDAO.getAll();
        try {
            String request = objectMapper.writeValueAsString(massageDAO);
            return request;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin
    @PostMapping("/adminPane")
    public String choiceMessage(@RequestParam("Date") Date date, @RequestParam("message") String message) {
        long time = System.currentTimeMillis();
        time += 86400000;
        if(time > date.getTime()) {
            Diary diary = new Diary();
            diary.setDate(date);
            message = message.substring(0,message.indexOf("\n"));
            diary.setMassage(message);
            diaryDAO.save(diary);
            return "{\"accesses\":\"user\", \"Url\":\"C:/Users/Developer/IdeaProjects/web-app/src/main/webapp/WEB-INF/Views/user.html\"}";
        }
        return null;

    }


}
