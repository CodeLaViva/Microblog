package com.lhz.controller;

import com.lhz.dao.CommentsDao;
import com.lhz.dao.MessagesDao;
import com.lhz.dao.UserinfoDao;
import com.lhz.model.Comments;
import com.lhz.model.Messages;
import com.lhz.model.Userinfo;
import com.lhz.model.Users;
import com.lhz.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

@Controller
// Session范围 将user存入到session
@SessionAttributes(value = "user")
public class MicroBlogController {
    LoginService loginService = new LoginService();

    //页面和方法参数一一对应
    @RequestMapping(value = "login2.do")
    //ModelMap参数携带者
    public String login2(String username, String user_password, ModelMap map) {
        //System.out.println("vote_password = " + vote_password);
        //System.out.println("vote_username = " + vote_username);
        if (loginService.login(username, user_password)) {
            map.put("msg", "登录成功……");
            map.put("user", username);
            return "success";
        }
        map.put("msg", "登录失败……");
        return "login";
    }

    @RequestMapping(value = "login.do")
    @ResponseBody
    public Users login(@RequestBody Map map) {
        //userService.batchSave(users);
        System.out.println(map.get("username"));
        System.out.println(map.get("user_password"));

        Users users = new Users();
        users.setUser_id((String) map.get("username"));
        users.setUser_password((String) map.get("user_password"));
        return users;
        //System.out.println(users);
    }


    @RequestMapping(value = "json.do")
    @ResponseBody
    public String login(@RequestBody Map map, ModelMap modelMap) {

        String username = (String) map.get("username"),
                user_password = (String) map.get("user_password");
        Users users = new Users();
        users.setUser_id(username);
        users.setUser_password(user_password);

        if (loginService.login(username, user_password)) {
            modelMap.put("msg", "登录成功……");
            String user_id = loginService.get_user_id(username);
            if (!user_id.equals("false")) {
                modelMap.put("user", user_id);
            }
            return "true";
        }

        modelMap.put("msg", "登录失败……");
        return "false";
    }

    @RequestMapping(value = "userinfo.do")
    @ResponseBody
    public Userinfo userinfo(@RequestBody Map map, ModelMap modelMap, HttpServletRequest request) {
        String userinfo_name = (String) map.get("userinfo_name"),
                userinfo_gender = (String) map.get("userinfo_gender"),
                userinfo_address = (String) map.get("userinfo_address"),
                userinfo_qq = (String) map.get("userinfo_qq"),
                userinfo_prof = (String) map.get("userinfo_prof"),
                userinfo_flag = (String) map.get("userinfo_flag"),
                user_id = (String) map.get("user_id");

        Date userinfo_birth = Date.valueOf((String) map.get("userinfo_birth"));

        //HttpSession httpSession = request.getSession();
        //user_id = (String) httpSession.getAttribute("username");

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

    @RequestMapping(value = "put_messages.do")
    @ResponseBody
    public Messages put_messages(@RequestBody Map map, ModelMap modelMap, HttpServletRequest request) {

        String messages_type = (String) map.get("messages_type"),
                messages_info = (String) map.get("messages_info"),
                messages_label = (String) map.get("messages_label"),
                user_id = (String) map.get("user_id");
        Timestamp messages_time;

        messages_time = new Timestamp(new java.util.Date().getTime());

        Messages messages = new Messages();
        messages.setMessages_type(messages_type);
        messages.setMessages_info(messages_info);
        messages.setMessages_label(messages_label);
        messages.setMessages_time(messages_time);
        messages.setUser_id(user_id);

        MessagesDao messagesDao = new MessagesDao();
        messagesDao.put_messages(messages);

        int messages_id = messagesDao.get_messages_id(messages_time);
        messages.setMessages_id(messages_id);

        return messages;
    }

    @RequestMapping(value = "put_comments.do")
    @ResponseBody
    public Comments put_comments(@RequestBody Map map, ModelMap modelMap, HttpServletRequest request) {
        int comments_id;
        String comments_info = (String) map.get("comments_info"),
                user_id = (String) map.get("user_id");
        int messages_id = (int) map.get("messages_id");

        Timestamp comments_time;

        comments_time = new Timestamp(new java.util.Date().getTime());

        Comments comments = new Comments();

        comments.setComments_info(comments_info);
        comments.setComments_time(comments_time);
        comments.setMessages_id(messages_id);
        comments.setUser_id(user_id);

        CommentsDao commentsDao = new CommentsDao();
        commentsDao.put_comments(comments);

        comments_id = commentsDao.get_comments_id(messages_id, user_id);
        comments.setComments_id(comments_id);


        return comments;
    }
}
