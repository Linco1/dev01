package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.entity.Collection;
import com.fc.service.AlleviationService;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageNum",defaultValue = "3")Integer pageSize,
                            Long id) {
        return alleviationService.getlist(pageNum,pageSize,id);

    }

    @PostMapping("add")
    public ResultVO add(@RequestBody Alleviation alleviation){
        System.out.println(alleviation);
        return alleviationService.add(alleviation);
    }
    @PostMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }
    @GetMapping ("delete")
    public ResultVO delete(Long id){
        return alleviationService.delete(id);
    }

    @PostMapping("click")
    public ResultVO click(Alleviation alleviation){
        return alleviationService.click(alleviation.getId(),alleviation.getLastClickTime());

    }

}
