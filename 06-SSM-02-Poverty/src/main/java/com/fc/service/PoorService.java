package com.fc.service;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;


import java.util.Date;

public interface PoorService {

    ResultVO getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(PoorWithBLOBs poorWithBLOBs);

    ResultVO update(PoorWithBLOBs poorWithBLOBs);

    ResultVO delete(Long id);

    ResultVO click(Long id, Date lastClickTime);

}
