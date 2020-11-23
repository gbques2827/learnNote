package com.gbques.ly.malltiny01.document.repository;

import com.gbques.ly.malltiny01.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 * Created by macro on 2018/6/19.
 */

/*
* 继承ElasticsearchRepository接口，这样就拥有了一些基本的
* Elasticsearch数据操作方法，同时定义了一个衍生查询方法。
* */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * 搜索查询
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    //这个方法是和jpa语法类似，可以通过关键字拼接起来的，不需要自己实现
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);


}
