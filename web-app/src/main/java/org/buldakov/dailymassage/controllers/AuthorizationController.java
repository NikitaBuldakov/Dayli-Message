package org.buldakov.dailymassage.controllers;

import org.buldakov.dailymassage.Models.User;
import org.buldakov.dailymassage.dao.DiaryDAO;
import org.buldakov.dailymassage.dao.MassageDAO;
import org.buldakov.dailymassage.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class AuthorizationController {

    private final UserDAO userDAO;
    private final DiaryDAO diaryDAO;
    private final MassageDAO messageDAO;
    private User user;

    @Autowired
    public AuthorizationController( UserDAO userDAO, DiaryDAO diaryDAO, MassageDAO messageDAO) {
        this.userDAO = userDAO;
        this.diaryDAO = diaryDAO;
        this.messageDAO = messageDAO;
    }

    @CrossOrigin
    @GetMapping ("/getPath")
    public void getPath(){
        try {
            Desktop desktop = Desktop.getDesktop();
            URI url = new URI("C:/Users/Developer/IdeaProjects/web-app/src/main/webapp/WEB-INF/Views/Auth.html");
            desktop.browse(url);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        //return "{\"Url\":\"C:/Users/Developer/IdeaProjects/web-app/src/main/webapp/WEB-INF/Views/Auth.html\"}";
    }

    @CrossOrigin
    @PostMapping("/authorization")
    public String authorization(@RequestParam String mail, @RequestParam String password) {
        user = userDAO.getOne(mail);


        if(user.password.equals(password)&& !user.admin) {
            return  "{\"accesses\":\"user\", \"Url\":\"C:/Users/Developer/IdeaProjects/web-app/src/main/webapp/WEB-INF/Views/user.html\"}";
        }else if(user.password.equals(password) && user.admin){
            return "{\"accesses\":\"admin\", \"Url\":\"C:/Users/Developer/IdeaProjects/web-app/src/main/webapp/WEB-INF/Views/admin.html\"}";
        }else{
            return "{\"accesses\":\"rejected\"}";
        }
    }
}
