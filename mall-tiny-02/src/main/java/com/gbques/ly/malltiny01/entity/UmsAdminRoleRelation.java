package com.gbques.ly.malltiny01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 后台用户和角色关系表
 * </p>
 *
 * @author ly
 * @since 2020-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UmsAdminRoleRelation对象", description="后台用户和角色关系表")
public class UmsAdminRoleRelation implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long adminId;

    private Long roleId;


}
