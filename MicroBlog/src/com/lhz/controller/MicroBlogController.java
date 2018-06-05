package com.lhz.controller;

import com.lhz.dao.CommentsDao;
import com.lhz.dao.MessagesDao;
import com.lhz.dao.UsersDao;
import com.lhz.model.Comments;
import com.lhz.model.Messages;
import com.lhz.model.Users;
import com.lhz.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
public class MicroBlogController {
    LoginService loginService = new LoginService();

    //页面和方法参数一一对应
    @RequestMapping(value = "login2.do")
    //ModelMap参数携带者
    public String login2(String username, String user_password, ModelMap map) {
        //System.out.println("vote_password = " + vote_password);
        //System.out.println("vote_username = " + vote_username);
        if (loginService.login(username, user_password)) {
            //map.put("msg", "登录成功……");
            //map.put("user", username);
            return "success";
        }
        //map.put("msg", "登录失败……");
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
    public Users login(@RequestBody Map map, ModelMap modelMap) {

        String username = (String) map.get("username"),
                user_password = (String) map.get("user_password");
        Users users = new Users();

        if (loginService.login(username, user_password)) {
            modelMap.put("msg", "登录成功……");
            String user_id = loginService.get_user_id(username);
            if (!user_id.equals("false")) {
                users = new UsersDao().get_users(user_id);
                modelMap.put("user", user_id);
            }
            return users;
        }

        modelMap.put("msg", "登录失败……");
        return null;
    }

    @RequestMapping(value = "register.do")
    @ResponseBody
    public Users register(@RequestBody Map map) {
        String user_id = (String) map.get("user_id"),
                user_phone = (String) map.get("user_phone"),
                user_email= (String) map.get("user_email"),
                user_password = (String) map.get("user_password"),
                user_nikename = (String) map.get("user_nikename");

        Users user = new Users();
        user.setUser_id(user_id);
        user.setUser_phone(user_phone);
        user.setUser_email(user_email);
        user.setUser_password(user_password);
        user.setUser_nikename(user_nikename);
        user.setUser_time(new Timestamp(new java.util.Date().getTime()));
        user.setUser_status(1);

        UsersDao usersDao = new UsersDao();
        usersDao.put_users(user);

        return user;
    }

    @RequestMapping(value = "put_messages.do")
    @ResponseBody
    public Messages put_messages(@RequestBody Map map) {

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

    @RequestMapping(value = "get_messages.do")
    @ResponseBody
    public List<Messages> get_messages(@RequestBody Map map) {
        String user_id = (String) map.get("user_id");

        MessagesDao messagesDao = new MessagesDao();

        List<Messages> messages = messagesDao.get_messages(user_id);
        return messages;
    }

    @RequestMapping(value = "put_comments.do")
    @ResponseBody
    public Comments put_comments(@RequestBody Map map) {
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

    @RequestMapping(value = "get_comments.do")
    @ResponseBody
    public List<Comments> get_comments(@RequestBody Map map) {
        String user_id = (String) map.get("user_id");

        CommentsDao commentsDao = new CommentsDao();

        List<Comments> comments = commentsDao.get_comments(user_id);
        return comments;
    }
}
