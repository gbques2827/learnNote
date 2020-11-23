package com.gbques.ly.malltiny01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbques.ly.malltiny01.dao.BrandMapper;
import com.gbques.ly.malltiny01.entity.Brand;
import com.gbques.ly.malltiny01.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author ly
 * @since 2020-11-18
 */
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Resource
    private BrandMapper brandMapper;
    //查询全部
    @Override
    public List<Brand> listAllBrand() {
        return brandMapper.selectList(null);
    }

    //插入
    @Override
    public int createBrand(Brand brand) {
        return baseMapper.insert(brand);
    }

    //更新
    @Override
    public int updateBrand(Brand brand) {
        return baseMapper.updateById(brand);
    }

    //删除
    @Override
    public int deleteBrand(Long id) {
        return baseMapper.deleteById(id);
    }

    //分页查询
    @Override
    public IPage<Brand> listBrand(int pageNum, int pageSize) {
        Page<Brand> pageParam = new Page<>(pageNum, pageSize);
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        return baseMapper.selectPage(pageParam,queryWrapper);
    }

    //单个查询
    @Override
    public Brand getBrand(Long id) {
        return baseMapper.selectById(id);
    }
}
