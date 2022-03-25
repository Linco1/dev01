package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.Collection;
import com.fc.service.AlleviationService;
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
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;
    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        List<Alleviation> alleviations;

        ResultVO resultVO = new ResultVO();
        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
                alleviations = alleviationMapper.selectByExample(null);
            } else {
                Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);
                alleviations = new ArrayList<>();
                alleviations.add(alleviation);

                click(alleviation.getId(),null);
            }

            PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);

            DataVO<Alleviation> dataVO = new DataVO<>(pageInfo.getTotal(), alleviations, pageNum, pageSize);

            resultVO = new ResultVO(200, "收藏表获取成功", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "收藏表获取失败", false, null);

        }

        return resultVO;
    }

    @Override
    public ResultVO add(Alleviation alleviation) {
       if (alleviation.getCreateTime() == null) {
           alleviation.setCreateTime(new Date());
        }
       if (alleviation.getReleaseTime() == null){
            alleviation.setReleaseTime(null);
       }

       alleviation.setClickNum(0) ;
        int affected = alleviationMapper.insertSelective(alleviation);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "扶贫政策添加成功", true, alleviation);
        } else {
            resultVO = new ResultVO(-1000, "扶贫政策添加失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(Alleviation alleviation) {
        int affected = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        ResultVO resultVO;
        if (affected > 0) {
            Alleviation result = alleviationMapper.selectByPrimaryKey(alleviation.getId());
            resultVO = new ResultVO(200, "扶贫政策修改成功", true, result);
        } else {
            resultVO = new ResultVO(-1000, "扶贫政策修改失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        int affected = alleviationMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "扶贫政策删除成功", true, null);
        } else {
            resultVO = new ResultVO(-1000, "扶贫政策删除失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if (lastClickTime == null){
            lastClickTime = new Date();

        }
      Integer affected = alleviationMapper.click(id,lastClickTime);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "点击量+1", true, null);
        } else {
            resultVO = new ResultVO(-1000, "点击失败", false, null);
        }
        return resultVO;
    }
}
