package com.fc.controller;

import com.fc.service.FileService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("uploadImg")
    public ResultVO upload(MultipartFile file,@RequestParam String type){
        return fileService.fileUpload(file, type);
    }
}
