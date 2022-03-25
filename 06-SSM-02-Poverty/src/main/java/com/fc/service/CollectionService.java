package com.fc.service;

import com.fc.entity.Collection;
import com.fc.entity.User;
import com.fc.vo.ResultVO;

public interface CollectionService {
    ResultVO getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(Collection collection);

    ResultVO update(Collection collection);

    ResultVO delete(Long id);

}