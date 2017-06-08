package com.app.srtarter;

import com.app.DAO.UserDAO;
import com.app.model.User;


/**
 * Created by User on 04.06.2017.
 */
public class JDBCStarter {
    public static void main(String[] args) {
//        User user = new User("Alex", "123581321lL","mar@gmail");
//        for (int i = 8; i > 0; i--) {
//            user = new User("Alex"+ i, "123581321lL" + i,"mar@gmail" + i);
//            UserDAO.create(user.getName(),user.getPassword(),user.getEmail());


//    }


User user = UserDAO.read("Alex7","mar@gmail7");
        System.out.println(user);

        if(user.getEmail()!=null){
            UserDAO.updateByID(user.getId(),"new Alex7", "new pass7", "new email7");
        }
    }
//    if(isPresent(user.getEmail)){
//
//    }
}
