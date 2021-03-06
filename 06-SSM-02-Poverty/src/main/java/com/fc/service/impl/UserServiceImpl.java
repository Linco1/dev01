package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        List<User> users;

        ResultVO resultVO = new ResultVO();
        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
                users = userMapper.selectByExample(null);
            } else {
                User user = userMapper.selectByPrimaryKey(id);
                users = new ArrayList<>();
                users.add(user);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVO<User> dataVO = new DataVO<>(pageInfo.getTotal(), users, pageNum, pageSize);

            resultVO = new ResultVO(200, "Ok", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "fail", false, null);

        }

        return resultVO;
    }

    @Override
    public ResultVO add(User user) {
        if (user.getCreateTime() == null) {
            user.setCreateTime(new Date());
        }
        int affected = userMapper.insertSelective(user);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "Ok", true, user);
        } else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(User user) {
        int affected = userMapper.updateByPrimaryKeySelective(user);
        ResultVO resultVO;
        if (affected > 0) {
            User result = userMapper.selectByPrimaryKey(user.getId());
            resultVO = new ResultVO(200, "Ok", true, result);
        } else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        int affected = userMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "Ok", true, null);
        } else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }
}