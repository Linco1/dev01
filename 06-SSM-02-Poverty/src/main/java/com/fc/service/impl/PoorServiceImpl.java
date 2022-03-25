package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        List<PoorWithBLOBs> poorWithBLOBs;

        ResultVO resultVO = new ResultVO();
        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
                poorWithBLOBs = poorMapper.selectByExampleWithBLOBs(null);
            } else {
                PoorWithBLOBs poor = poorMapper.selectByPrimaryKey(id);
                poorWithBLOBs = new ArrayList<>();
                poorWithBLOBs.add(poor);
                click(poor.getId(),null);


            }

            PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poorWithBLOBs);

            DataVO<PoorWithBLOBs> dataVO = new DataVO<>(pageInfo.getTotal(), poorWithBLOBs, pageNum, pageSize);

            resultVO = new ResultVO(200, "贫困户获取成功", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "贫困户获取失败", false, null);

        }

        return resultVO;
    }

    @Override
    public ResultVO add(PoorWithBLOBs poorWithBLOBs) {

        if (poorWithBLOBs.getCreateTime() == null) {
            poorWithBLOBs.setCreateTime(new Date());
        }

        poorWithBLOBs.setClickNum(0) ;
        int affected = poorMapper.insertSelective(poorWithBLOBs);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "贫困户添加成功", true, poorWithBLOBs);
        } else {
            resultVO = new ResultVO(-1000, "贫困户添加失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(PoorWithBLOBs poorWithBLOBs) {
        int affected = poorMapper.updateByPrimaryKeySelective(poorWithBLOBs);
        ResultVO resultVO;
        if (affected > 0) {
            Poor result = poorMapper.selectByPrimaryKey(poorWithBLOBs.getId());
            resultVO = new ResultVO(200, "贫困户修改成功", true, result);
        } else {
            resultVO = new ResultVO(-1000, "贫困户修改失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        int affected = poorMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "贫困户删除成功", true, null);
        } else {
            resultVO = new ResultVO(-1000, "贫困户删除失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if (lastClickTime == null){
            lastClickTime = new Date();

        }
        Integer affected = poorMapper.click(id,lastClickTime);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "点击量+1", true, null);
        } else {
            resultVO = new ResultVO(-1000, "点击失败", false, null);
        }
        return resultVO;
    }
}
