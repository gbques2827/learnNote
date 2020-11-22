package com.gbques.ly.malltiny01.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbques.ly.malltiny01.dao.UmsAdminMapper;
import com.gbques.ly.malltiny01.dao.UmsAdminRoleRelationMapper;
import com.gbques.ly.malltiny01.entity.UmsAdmin;
import com.gbques.ly.malltiny01.entity.UmsPermission;
import com.gbques.ly.malltiny01.service.UmsAdminService;
import com.gbques.ly.malltiny01.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author ly
 * @since 2020-11-21
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
   /* @Value("${jwt.tokenHead}")
    private String tokenHead;*/
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;

    //根据用户名获取用户
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            return null;
        }
        QueryWrapper<UmsAdmin> umsAdminQueryWrapper = new QueryWrapper<>();
        umsAdminQueryWrapper.eq("username",username);
        return adminMapper.selectOne(umsAdminQueryWrapper);
    }

    //注册
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        if(getAdminByUsername(umsAdmin.getUsername())!=null){
            return null;
        }

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            /*
             * =AdminUserDetails{umsAdmin=UmsAdmin(id=3, username=admin,
             * password=$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO,
             * icon=http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/170157_yIl3_1767531.jpg,
             * email=admin@163.com, nickName=系统管理员, note=系统管理员,
             * createTime=Mon Oct 08 13:32:47 CST 2018, loginTime=Wed Mar 20 15:38:50 CST 2019, status=1),
             * permissionList=[UmsPermission(id=1, pid=0, name=商品, value=null, icon=null, type=0, uri=null, status=1, createTime=Sat Sep 29 16:15:14 CST 2018, sort=0),
             * UmsPermission(id=2, pid=1, name=商品列表, value=pms:product:read, icon=null, type=1, uri=/pms/product/index, status=1, createTime=Sat Sep 29 16:17:01 CST 2018, sort=0),
             * UmsPermission(id=3, pid=1, name=添加商品, value=pms:product:create, icon=null, type=1, uri=/pms/product/add, status=1, createTime=Sat Sep 29 16:18:51 CST 2018, sort=0),
             * UmsPermission(id=7, pid=2, name=编辑商品, value=pms:product:update, icon=null, type=2, uri=/pms/product/updateProduct, status=1, createTime=Sat Sep 29 16:
             * */
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            //获取权限
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            //设置权限
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    //根据用户id获取其权限
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationMapper.getPermissionList(adminId);
    }
}
