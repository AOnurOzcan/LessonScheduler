package com.lessonscheduler.service;

import com.lessonscheduler.dao.UserDao;
import com.lessonscheduler.domain.User;
import com.lessonscheduler.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Onur on 4.4.2017.
 */

@Service
public class UserService {

    @Autowired
    HttpSession httpSession;

    @Autowired
    UserDao userDao;

    @Transactional
    public void registerUser(UserDto userDto) throws Exception {

        User user;
        List<User> userList;

        //Aynı kullanıcı adında başka bir kullanıcı var mı diye bakılıyor.
        userList = userDao.findByUsername(userDto.getUsername());

        if (userList.size() == 0) { //Yoksa kayıt yapılıyor

            user = new User();
            user.setAccountType(0);
            user.setName(userDto.getName());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user = userDao.persist(user);

            UserDto sessionObject = new UserDto();

            sessionObject.setUsername(user.getUsername());
            sessionObject.setName(user.getName());
            sessionObject.setAccountType(user.getAccountType());
            sessionObject.setId(user.getId());

            httpSession.setAttribute("user", sessionObject);
        } else {
            //Bu kullanıcı adı zaten var.
            throw new Exception("Bu kullanıcı adı sistemde kayıtlı.");
        }

    }

    public UserDto login(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        user = userDao.findByUsernameAndPassword(user);

        UserDto sessionObject = new UserDto();

        sessionObject.setUsername(user.getUsername());
        sessionObject.setName(user.getName());
        sessionObject.setAccountType(user.getAccountType());
        sessionObject.setId(user.getId());

        httpSession.setAttribute("user", sessionObject);

        return sessionObject;
    }

    public UserDto checkAuthentication() {
        UserDto user = (UserDto) httpSession.getAttribute("user");

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public void invalidateSession() {
        httpSession.invalidate();
    }

}
