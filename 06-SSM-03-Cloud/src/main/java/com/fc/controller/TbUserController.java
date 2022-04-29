package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class TbUserController {
    @Autowired
    private UserService userService;
    @RequestMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                            Long id) {
        return userService.getlist(pageNum,pageSize,id);

    }

    @RequestMapping("add")
    public ResultVO add(@RequestBody TbUser user){
        System.out.println(user);
        return userService.add(user);
    }
    @RequestMapping("update")
    public ResultVO update(@RequestBody TbUser user){
        return userService.update(user);
    }
    @RequestMapping ("delete")
    public ResultVO delete(Long id){
        return userService.delete(id);
    }


}


