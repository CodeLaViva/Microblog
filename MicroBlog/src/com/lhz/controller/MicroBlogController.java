package com.lhz.controller;

import com.lhz.dao.MessagesDao;
import com.lhz.dao.UserinfoDao;
import com.lhz.model.Messages;
import com.lhz.model.Userinfo;
import com.lhz.service.LoginService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;

@Controller
// Session范围 将user存入到session
@SessionAttributes(value = "user")
public class MicroBlogController {
    LoginService loginService = new LoginService();

    //页面和方法参数一一对应
    @RequestMapping(value = "login.do")
    //ModelMap参数携带者
    public String login(String username, String user_password, ModelMap map) {
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

    @RequestMapping(value = "json.do")
    @ResponseBody
    public String login(HttpServletRequest request, ModelMap map) {
        //String json_test = "{\"username\":\"lhz\",\"user_password\":\"123\"}";
        String jsonData_login = request.getParameter("login");  //数据必须为'[..]'格式
        //System.out.println(jsonData_login);
        String username = null, user_password = null;

        if (!jsonData_login.equals("")) {
            JSONObject jsonObj = JSONObject.fromObject(jsonData_login);
            username = (String) jsonObj.get("username");
            user_password = (String) jsonObj.get("user_password");
        }

        if (loginService.login(username, user_password)) {
            map.put("msg", "登录成功……");
            String user_id = loginService.get_user_id(username);
            if (!user_id.equals("false")) {
                map.put("user", user_id);
            }
            return "true";
        }

        map.put("msg", "登录失败……");
        return "false";
    }

    @RequestMapping(value = "userinfo.do")
    @ResponseBody
    public Userinfo userinfo(HttpServletRequest request, ModelMap map){
        String jsonData_put_messages = request.getParameter("userinfo");  //数据必须为'{..}'格式
        //System.out.println(jsonData_put_messages);
        String userinfo_name = null,
                userinfo_gender = null,
                userinfo_address = null,
                userinfo_qq = null,
                userinfo_prof = null,
                userinfo_flag = null,
                user_id;
        Date userinfo_birth = null;

        if (!jsonData_put_messages.equals("")) {
            JSONObject jsonObj = JSONObject.fromObject(jsonData_put_messages);
            userinfo_name = (String) jsonObj.get("userinfo_name");
            userinfo_gender = (String) jsonObj.get("userinfo_gender");
            userinfo_address = (String) jsonObj.get("userinfo_address");
            userinfo_birth = (Date) jsonObj.get("userinfo_birth");
            userinfo_qq = (String) jsonObj.get("userinfo_qq");
            userinfo_prof = (String) jsonObj.get("userinfo_prof");
            userinfo_flag = (String) jsonObj.get("userinfo_flag");
        }

        HttpSession httpSession = request.getSession();
        user_id = (String) httpSession.getAttribute("username");

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
        if(userinfo_id != 0){
            userinfo.setUserinfo_id(userinfo_id);
        }

        return userinfo;
    }

    @RequestMapping(value = "put_messages.do")
    @ResponseBody
    public Messages put_messages(HttpServletRequest request, ModelMap map) {

        String jsonData_put_messages = request.getParameter("put_messages");  //数据必须为'{..}'格式
        //System.out.println(jsonData_put_messages);
        String messages_type = null, messages_info = null, messages_label = null, user_id;
        Timestamp messages_time = null;

        if (!jsonData_put_messages.equals("")) {
            JSONObject jsonObj = JSONObject.fromObject(jsonData_put_messages);
            messages_type = (String) jsonObj.get("messages_type");
            messages_info = (String) jsonObj.get("messages_info");
            messages_label = (String) jsonObj.get("messages_label");
        }

        HttpSession httpSession = request.getSession();
        user_id = (String) httpSession.getAttribute("username");

        messages_time = new Timestamp(new java.util.Date().getTime());

        /*System.out.println("messages_type: " + messages_type);
        System.out.println("messages_info: " +messages_info);
        System.out.println("messages_label: " +messages_label);
        System.out.println("messages_time: " +messages_time);
        System.out.println("username: " + user_id);*/

        Messages messages = new Messages();
        messages.setMessages_type(messages_type);
        messages.setMessages_info(messages_info);
        messages.setMessages_label(messages_label);
        messages.setMessages_time(messages_time);
        messages.setUser_id(user_id);

        MessagesDao messagesDao = new MessagesDao();
        messagesDao.put_messages(messages);

        return messages;
    }

    @Test
    public void test() {
        /*String jsonStr = "{\"id\":\"3\",\"name\":\"bob\",\"pass\":\"123\"}";
        System.out.println(jsonStr);
        JSONObject jsonObj = JSONObject.fromObject(jsonStr);
        System.out.println(jsonObj.get("name"));
        String arrStr = "[{\"id\":\"3\",\"name\":\"bob\",\"pass\":\"123\"},{\"id\":\"4\",\"name\":\"lancy\",\"pass\":\"134\"}]";
        System.out.println(arrStr);
        JSONArray jsonArr = JSONArray.fromObject(arrStr);
        System.out.println(jsonArr.getJSONObject(1).get("name"));
        Iterator<Object> it = jsonArr.iterator();
        while(it.hasNext()){
            JSONObject obj = (JSONObject)it.next();
            System.out.println("name:"+obj.get("name")+" pass:"+obj.get("pass"));
        }*/

        String json_test = "{\"username\":\"lhz\",\"user_password\":\"123\"}";
        System.out.println(json_test);
        String username = null, user_password = null;

        JSONObject jsonObj = JSONObject.fromObject(json_test);
        System.out.println("jsonObj: " + jsonObj);
        username = (String) jsonObj.get("username");
        System.out.println(username);
        user_password = (String) jsonObj.get("user_password");
        System.out.println(user_password);
    }
}
