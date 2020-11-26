package com.gbques.ly.malltiny01.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ly
 * @since 2020-11-26 10:03
 * 获取OSS上传文件授权返回结果
 * 前端直接上传文件时所需参数，从后端返回过来
 */
@Data
public class OssPolicyResult {
    /*
    返回的数据：
    * "data": {
    "accessKeyId": "LTAI4GB9NJigKeZoeMntBP3W",
    "policy": "eyJleHBpcmF0aW9uIjoiMjAyMC0xMS0yNlQwMzowODo0MC41NzJaIiwiY29uZGl0aW9ucyI6W1siY29udGVudC1sZW5ndGgtcmFuZ2UiLDAsMTA0ODU3NjBdLFsic3RhcnRzLXdpdGgiLCIka2V5IiwibWFsbC9pbWFnZXMvMjAyMDExMjYiXV19",
    "signature": "7yI7lMA9ZvvxBvFdfUSkMUyi+2Q=",
    "dir": "mall/images/20201126",
    "host": "http://gbques-music.oss-cn-hangzhou.aliyuncs.com",
    "callback": "eyJjYWxsYmFja0JvZHlUeXBlIjoiYXBwbGljYXRpb24veC13d3ctZm9ybS11cmxlbmNvZGVkIiwiY2FsbGJhY2tVcmwiOiJodHRwOi8vbG9jYWxob3N0OjgwODEvYXBpL2FsaXl1bi9vc3MvY2FsbGJhY2siLCJjYWxsYmFja0JvZHkiOiJmaWxlbmFtZT0ke29iamVjdH0mc2l6ZT0ke3NpemV9Jm1pbWVUeXBlPSR7bWltZVR5cGV9JmhlaWdodD0ke2ltYWdlSW5mby5oZWlnaHR9JndpZHRoPSR7aW1hZ2VJbmZvLndpZHRofSJ9"
  }
    */
    @ApiModelProperty("访问身份验证中用到用户标识")
    private String accessKeyId;
    @ApiModelProperty("用户表单上传的策略,经过base64编码过的字符串")
    private String policy;
    @ApiModelProperty("对policy签名后的字符串")
    private String signature;
    @ApiModelProperty("上传文件夹路径前缀")
    private String dir;
    @ApiModelProperty("oss对外服务的访问域名")
    private String host;
    @ApiModelProperty("上传成功后的回调设置")
    private String callback;
}