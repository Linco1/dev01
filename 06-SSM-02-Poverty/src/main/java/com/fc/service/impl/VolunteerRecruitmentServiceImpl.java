package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.entity.Poor;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
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
public class VolunteerRecruitmentServiceImpl implements VolunteerRecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        List<VolunteerRecruitment> volunteerRecruitments;

        ResultVO resultVO = new ResultVO();
        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
                volunteerRecruitments = volunteerRecruitmentMapper.selectByExample(null);
            } else {
                VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);
                volunteerRecruitments = new ArrayList<>();
                volunteerRecruitments.add(volunteerRecruitment);
            }

            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);

            DataVO<VolunteerRecruitment> dataVO = new DataVO<>(pageInfo.getTotal(), volunteerRecruitments, pageNum, pageSize);

            resultVO = new ResultVO(200, "义工招募获取成功", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "义工招募失败", false, null);

        }

        return resultVO;
    }

    @Override
    public ResultVO add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime() == null) {
            volunteerRecruitment.setCreateTime(new Date());
        }
        int affected = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "义工招募添加成功", true, volunteerRecruitment);
        } else {
            resultVO = new ResultVO(-1000, "义工招募添加失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(VolunteerRecruitment volunteerRecruitment) {
        int affected = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        ResultVO resultVO;
        if (affected > 0) {
            VolunteerRecruitment result = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());
            resultVO = new ResultVO(200, "贫困户修改成功", true, result);
        } else {
            resultVO = new ResultVO(-1000, "贫困户修改失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        int affected = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
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
        Integer affected = volunteerRecruitmentMapper.click(id,lastClickTime);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "点击量+1", true, null);
        } else {
            resultVO = new ResultVO(-1000, "点击失败", false, null);
        }
        return resultVO;
    }
}
