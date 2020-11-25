package com.gbques.ly.malltiny01.service.impl;
/*
 *@author ly
 *@since 2020-11-24 17:25
 */

import com.gbques.ly.malltiny01.mongodb.MemberReadHistory;
import com.gbques.ly.malltiny01.mongodb.repository.MemberReadHistoryRepository;
import com.gbques.ly.malltiny01.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览记录管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    //增
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        //先将id置空，即直接让MongoDB自动生成id
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        //成功返回1
        return 1;
    }

    //删
    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    //查
    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
