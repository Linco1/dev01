package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messageBoard")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;
    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageNum",defaultValue = "3")Integer pageSize,
                            Long id) {
        return messageBoardService.getlist(pageNum,pageSize,id);

    }

    @PostMapping("add")
    public ResultVO add(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        System.out.println(messageBoardWithBLOBs);
        return messageBoardService.add(messageBoardWithBLOBs);
    }
    @PostMapping("update")
    public ResultVO update(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return messageBoardService.update(messageBoardWithBLOBs);
    }
    @GetMapping ("delete")
    public ResultVO delete(Long id){
        return messageBoardService.delete(id);
    }

}
