package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVO;

public interface UserService {
    ResultVO getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(TbUser user);

    ResultVO update(TbUser user);

    ResultVO delete(Long id);

}
