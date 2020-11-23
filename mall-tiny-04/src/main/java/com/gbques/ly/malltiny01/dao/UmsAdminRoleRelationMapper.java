package com.gbques.ly.malltiny01.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbques.ly.malltiny01.entity.UmsAdminRoleRelation;
import com.gbques.ly.malltiny01.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author ly
 * @since 2020-11-21
 */
@Repository
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
