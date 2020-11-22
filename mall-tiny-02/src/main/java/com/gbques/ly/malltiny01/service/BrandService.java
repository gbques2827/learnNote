package com.gbques.ly.malltiny01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gbques.ly.malltiny01.entity.Brand;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author ly
 * @since 2020-11-18
 */
public interface BrandService extends IService<Brand> {
    List<Brand> listAllBrand();

    int createBrand(Brand brand);

    int updateBrand(Brand brand);

    int deleteBrand(Long id);

    IPage<Brand> listBrand(int pageNum, int pageSize);

    Brand getBrand(Long id);
}
