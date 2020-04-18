package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public boolean login(String name, String password) throws  SQLException{
        //System.out.println(userDao.login(name, password));
        return userDao.login(name,password).isEmpty()==true ? false : true;
    }
}
