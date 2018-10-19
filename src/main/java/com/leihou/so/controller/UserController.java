package com.leihou.so.controller;
import com.leihou.so.entity.User;
import com.leihou.so.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

/**
 *
 * Created by ruibiaozhong on 2018/10/19.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    UserService userService;


    @PostMapping("create")
    public String add(User user) {
        userService.insert(user);
        return "";
    }

    @DeleteMapping("delete")
    public String delete(@RequestParam Integer id) {
	    userService.deleteByPrimaryKey(id);
	    return "";
    }

    @PutMapping("update")
    public String update(User user) {
	    userService.updateByPrimaryKey(user);
	    return "";
    }

    @GetMapping("detail")
    public String detail(@RequestParam Integer id) {
        User user = userService.selectByPrimaryKey(id);



        return user.toString();
    }

    @GetMapping("list")
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
