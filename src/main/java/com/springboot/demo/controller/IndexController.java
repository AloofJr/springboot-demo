package com.springboot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.repository.po.Users;
import com.springboot.demo.service.UsersService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author aloofJr
 * @date 2019/3/21
 */
@RestController
public class IndexController {
    @Resource
    private UsersService usersService;

    @RequestMapping("index")
    public void index(ModelMap modelMap, HttpServletRequest request, @RequestParam(value = "idList[]") String[] idList) {
        System.out.println(idList);
    }

    @RequestMapping("getUsers")
    public Users getUsers(ModelMap modelMap, HttpServletRequest request, @RequestBody List<Users> users) {

        users.forEach(user -> {
            System.out.println(user.toString());
        });

        return users.get(0);
    }

    @RequestMapping("addUsers")
    public boolean addUsers(ModelMap modelMap, HttpServletRequest request) {
        Users users = new Users();
        users.setNickName("wangqi");
        users.setPassword("1234");
        users.setUsername("wang");
        users.setUserSex("man");
        return usersService.addUser(users);
    }

    @RequestMapping("getUsersByCondition")
    public List<Users> getUsersByCondition(ModelMap modelMap, HttpServletRequest request) {

        String id = request.getParameter("id");
        Users users = new Users();
        if (id != null) {
            users.setId(Long.parseLong(id));
        }
        /*for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }*/

        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }


        users.setUserSex(request.getParameter("userSex"));
        users.setUsername(request.getParameter("userName"));
        users.setPassword(request.getParameter("password"));
        users.setNickName(request.getParameter("nickName"));
        System.out.println(users);
        return usersService.getUserByCondition(users);
    }

    @RequestMapping("testUrl")
    public String testUrl(ModelMap modelMap, HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();

        return JSONObject.toJSONString(map);
    }

}
