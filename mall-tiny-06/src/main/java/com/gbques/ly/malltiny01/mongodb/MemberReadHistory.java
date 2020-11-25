package com.gbques.ly.malltiny01.mongodb;

/**
 * @author ly
 * @since 2020-11-24 17:20
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 用户商品浏览历史记录
 * Created by macro on 2018/8/3.
 */
@Document //表的概念，默认生成类的首字母小写：memberReadHistory
@Data
public class MemberReadHistory {
    @Id //对应_id，应该表示主键，必须存在的
    private String id;
    @Indexed //表示索引
    private Long memberId;
    private String memberNickname;
    private String memberIcon;
    @Indexed //表示索引
    private Long productId;
    private String productName;
    private String productPic;
    private String productSubTitle;
    private String productPrice;
    private Date createTime;

}
