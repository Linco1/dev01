package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
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
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        List<MessageBoardWithBLOBs> messageBoardWithBLOBs;

        ResultVO resultVO = new ResultVO();
        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);
                messageBoardWithBLOBs = messageBoardMapper.selectByExampleWithBLOBs(null);
            } else {
                MessageBoardWithBLOBs messageBoardWithBLOBs1 = messageBoardMapper.selectByPrimaryKey(id);
                messageBoardWithBLOBs = new ArrayList<>();
                messageBoardWithBLOBs.add(messageBoardWithBLOBs1);
            }

            PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoardWithBLOBs);

            DataVO<MessageBoardWithBLOBs> dataVO = new DataVO<>(pageInfo.getTotal(), messageBoardWithBLOBs, pageNum, pageSize);

            resultVO = new ResultVO(200, "留言板获取成功", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "留言板获取失败", false, null);

        }

        return resultVO;
    }

    @Override
    public ResultVO add(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        if (messageBoardWithBLOBs.getCreateTime() == null) {
            messageBoardWithBLOBs.setCreateTime(new Date());
        }
        int affected = messageBoardMapper.insertSelective(messageBoardWithBLOBs);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "留言板添加成功", true, messageBoardWithBLOBs);
        } else {
            resultVO = new ResultVO(-1000, "留言板添加失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        int affected = messageBoardMapper.updateByPrimaryKeySelective(messageBoardWithBLOBs);
        ResultVO resultVO;
        if (affected > 0) {
            MessageBoard result = messageBoardMapper.selectByPrimaryKey(messageBoardWithBLOBs.getId());
            resultVO = new ResultVO(200, "留言板修改成功", true, result);
        } else {
            resultVO = new ResultVO(-1000, "留言板修改失败", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        int affected = messageBoardMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affected > 0) {
            resultVO = new ResultVO(200, "留言板删除成功", true, null);
        } else {
            resultVO = new ResultVO(-1000, "留言板删除失败", false, null);
        }
        return resultVO;
    }
}
