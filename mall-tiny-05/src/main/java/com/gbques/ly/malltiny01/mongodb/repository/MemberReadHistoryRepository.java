package com.gbques.ly.malltiny01.mongodb.repository;

/*
 * @author ly
 * @since 2020-11-24 17:21
 * 会员商品浏览历史Repository
 */

import com.gbques.ly.malltiny01.mongodb.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     * 继承接口，在接口中直接指定查询方法名称便可查询，无需进行实现
     * 使用方法如jpa,直接通过关键字进行拼接，无需实现
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}