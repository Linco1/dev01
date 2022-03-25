package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface VolunteerRecruitmentService {
    ResultVO getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(VolunteerRecruitment volunteerRecruitment);

    ResultVO update(VolunteerRecruitment volunteerRecruitment);

    ResultVO delete(Long id);

    ResultVO click(Long id, Date lastClickTime);

}
