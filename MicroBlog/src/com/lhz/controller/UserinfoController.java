package com.lhz.controller;

import com.lhz.dao.UserinfoDao;
import com.lhz.model.Userinfo;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@RestController
public class UserinfoController {

    @RequestMapping(value = "userinfo.do", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Userinfo get_userinfo(@RequestBody Map map) {
        String user_id = (String) map.get("user_id");
        //String user_id = request.getParameter("user_id");HttpServletRequest request

        UserinfoDao userinfoDao = new UserinfoDao();
        Userinfo userinfo = userinfoDao.get_userinfo(user_id);
        return userinfo;
    }

    @RequestMapping(value = "userinfo.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Userinfo insert_userinfo(@RequestBody Map map) {
        String userinfo_name = (String) map.get("userinfo_name"),
                userinfo_gender = (String) map.get("userinfo_gender"),
                userinfo_address = (String) map.get("userinfo_address"),
                userinfo_qq = (String) map.get("userinfo_qq"),
                userinfo_prof = (String) map.get("userinfo_prof"),
                userinfo_flag = (String) map.get("userinfo_flag"),
                user_id = (String) map.get("user_id");

        Date userinfo_birth = Date.valueOf((String) map.get("userinfo_birth"));

        Userinfo userinfo = new Userinfo();
        userinfo.setUserinfo_name(userinfo_name);
        userinfo.setUserinfo_gender(userinfo_gender);
        userinfo.setUserinfo_address(userinfo_address);
        userinfo.setUserinfo_birth(userinfo_birth);
        userinfo.setUserinfo_qq(userinfo_qq);
        userinfo.setUserinfo_prof(userinfo_prof);
        userinfo.setUserinfo_flag(userinfo_flag);
        userinfo.setUser_id(user_id);

        UserinfoDao userinfoDao = new UserinfoDao();
        userinfoDao.userinfo(userinfo);

        int userinfo_id = userinfoDao.get_userinfo_id(user_id);
        if (userinfo_id != 0) {
            userinfo.setUserinfo_id(userinfo_id);
        }

        return userinfo;
    }

    @RequestMapping(value = "userinfo.do", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Userinfo update_userinfo(@RequestBody Map map) {
        String userinfo_name = (String) map.get("userinfo_name"),
                userinfo_gender = (String) map.get("userinfo_gender"),
                userinfo_address = (String) map.get("userinfo_address"),
                userinfo_qq = (String) map.get("userinfo_qq"),
                userinfo_prof = (String) map.get("userinfo_prof"),
                userinfo_flag = (String) map.get("userinfo_flag"),
                user_id = (String) map.get("user_id");

        Date userinfo_birth = Date.valueOf((String) map.get("userinfo_birth"));

        Userinfo userinfo = new Userinfo();
        userinfo.setUserinfo_name(userinfo_name);
        userinfo.setUserinfo_gender(userinfo_gender);
        userinfo.setUserinfo_address(userinfo_address);
        userinfo.setUserinfo_birth(userinfo_birth);
        userinfo.setUserinfo_qq(userinfo_qq);
        userinfo.setUserinfo_prof(userinfo_prof);
        userinfo.setUserinfo_flag(userinfo_flag);
        userinfo.setUser_id(user_id);

        UserinfoDao userinfoDao = new UserinfoDao();
        int userinfo_id = userinfoDao.get_userinfo_id(user_id);
        if (userinfo_id != 0) {
            userinfo.setUserinfo_id(userinfo_id);
        }
        userinfoDao.update_userinfo(userinfo);

        return userinfo;
    }

    @RequestMapping(value = "userinfo.do", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Userinfo delete_userinfo(@RequestBody Map map) {
        String user_id = (String) map.get("user_id");

        UserinfoDao userinfoDao = new UserinfoDao();
        userinfoDao.get_userinfo(user_id);

        Userinfo userinfo = new Userinfo();

        return userinfo;
    }
}
