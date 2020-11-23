package com.gbques.ly.malltiny01.controller;


import com.gbques.ly.malltiny01.common.CommonResult;
import com.gbques.ly.malltiny01.entity.Brand;
import com.gbques.ly.malltiny01.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2020-11-18
 */

@RequestMapping("/api/brand")
@RestController
@Api(tags = "商品品牌管理")
public class BrandController {
    @Autowired
    BrandService brandService;

    //查询全部
    @PreAuthorize("hasAuthority('pms:brand:read')")
    @GetMapping("/list")
    @ApiOperation("获取所有品牌列表")
    public CommonResult<List<Brand>> getBrandList() {
        return CommonResult.success( brandService.listAllBrand());
    }

    //插入
    @PreAuthorize("hasAuthority('pms:brand:create')")
    @ApiOperation("添加品牌")
    @PostMapping("/create")
    public  int getBrandList(Brand brand) {
        return brandService.createBrand(brand);
    }

    //更新
    @PreAuthorize("hasAuthority('pms:brand:update')")
    @GetMapping("/update")
    @ApiOperation("更新指定id品牌信息")
    public int update(Brand brand){
        return brandService.updateBrand(brand);
    }

    //删除
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    @ApiOperation("删除指定id的品牌")
    @GetMapping("/delete")
    public int delete(Long id){
        return brandService.deleteBrand(id);
    }

    //分页查询
    @ApiOperation("分页查询品牌列表")
    @GetMapping("/selectByPage")
    public List<Brand> selectByPage(@RequestParam(value = "pageNum", defaultValue = "1")
                                        @ApiParam("页码") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "3")
                                        @ApiParam("每页数量") Integer pageSize){
        return brandService.listBrand(pageNum,pageSize).getRecords();
    }

    //根据id查询
    @ApiOperation("获取指定id的品牌详情")
    @GetMapping("/selectById/{id}")
    public Brand selectById(@PathVariable("id") Long id){
        return brandService.getBrand(id);
    }
}

