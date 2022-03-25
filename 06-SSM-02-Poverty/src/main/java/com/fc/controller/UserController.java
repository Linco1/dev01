package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
@Autowired
    private UserService userService;
@RequestMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageNum",defaultValue = "3")Integer pageSize,
                                             Long id) {
    return userService.getlist(pageNum,pageSize,id);

}

    @RequestMapping("add")
    public ResultVO add(@RequestBody User user){
        System.out.println(user);
        return userService.add(user);
    }
    @RequestMapping("update")
    public ResultVO update(@RequestBody User user){
    return userService.update(user);
    }
    @RequestMapping ("delete")
    public ResultVO delete(Long id){
        return userService.delete(id);
    }


}
