package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        List<TbUser> tbUsers;

        ResultVO resultVO = new ResultVO();
        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
                tbUsers = tbUserMapper.selectByExample(null);
            } else {
                TbUser user = tbUserMapper.selectByPrimaryKey(56);
                tbUsers = new ArrayList<>();

            }

            PageInfo<TbUser> pageInfo = new PageInfo<>(tbUsers);

            DataVO<TbUser> dataVO = new DataVO<>(pageInfo.getTotal(), tbUsers, pageNum, pageSize);

            resultVO = new ResultVO(200, "Ok", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "fail", false, null);

        }

        return resultVO;
    }

    @Override
    public ResultVO add(TbUser user) {
        return null;
    }

    @Override
    public ResultVO update(TbUser user) {
        return null;
    }

    @Override
    public ResultVO delete(Long id) {
        return null;
    }
}
