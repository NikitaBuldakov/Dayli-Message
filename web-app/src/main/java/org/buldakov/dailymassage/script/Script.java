package org.buldakov.dailymassage.script;

import org.buldakov.dailymassage.Models.Diary;
import org.buldakov.dailymassage.Models.Massage;
import org.buldakov.dailymassage.dao.DiaryDAO;
import org.buldakov.dailymassage.dao.MassageDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Script {
    private final DiaryDAO diaryDAO;
    private final MassageDAO massageDAO;

    @Autowired
    public Script(DiaryDAO diaryDAO, MassageDAO massageDAO) {
        this.diaryDAO = diaryDAO;
        this.massageDAO = massageDAO;

        Check(this.diaryDAO);

    }

    public void Check(DiaryDAO diaryDAO){

        long time = System.currentTimeMillis();
        Date date= new Date(time);
        Massage massage = new Massage();
        Diary diary = diaryDAO.getOne(date);
        Random rn = new Random();

        if(diary == null){
            List<Massage> list = new ArrayList<>();
            list = massageDAO.getAll();
            massage = massageDAO.getOne(rn.nextInt(list.size() + 1));
            diary.setDate(date);
            diary.setMassage(massage.getMessage());
            diaryDAO.save(diary);
        }

    }

}
