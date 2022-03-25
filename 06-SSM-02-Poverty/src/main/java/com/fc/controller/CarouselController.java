package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carousel")
public class CarouselController {
@Autowired
    private CarouselService carouselService;

    @RequestMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageNum",defaultValue = "3")Integer pageSize,
                            Integer id) {
        return carouselService.getlist(pageNum,pageSize,id);

    }

    @RequestMapping("add")
    public ResultVO add(@RequestBody Carousel carousel){
        System.out.println(carousel);
        return carouselService.add(carousel);
    }
    @RequestMapping("update")
    public ResultVO update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }
    @RequestMapping ("delete")
    public ResultVO delete(Integer id){
        return carouselService.delete(id);
    }
    @RequestMapping("state")
    public ResultVO changeStatus(Integer id){
        return carouselService.changeStatus(id);
    }
}
